package org.castixz.municipality_importer.tasks;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.castixz.municipality_importer.exceptions.FileDownloadFailedException;
import org.castixz.municipality_importer.file.FileUtils;
import org.castixz.municipality_importer.mapper.MunicipalityMapper;
import org.castixz.municipality_importer.mapper.MunicipalityPartMapper;
import org.castixz.municipality_importer.parser.MunicipalityXMLParser;
import org.castixz.municipality_importer.repository.MunicipalityPartRepository;
import org.castixz.municipality_importer.repository.MunicipalityRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;


@Component
@RequiredArgsConstructor
@Slf4j
public class ImportMunicipalityTask implements BatchTask {

    private static final URL URL_TO_MUNICIPALITY_FILE;

    private static final String WORKDIR_PATH;

    private static final String WORKDIR_MUNICIPALITY_ZIP;

    private static final String FILE_TO_PARSE_PATH;

    static {
        try {
            URL_TO_MUNICIPALITY_FILE = new URI("""
                    https://www.smartform.cz/download/kopidlno.xml.zip""").toURL();
            WORKDIR_PATH = System.getProperty("user.dir") + "/workdir";
            WORKDIR_MUNICIPALITY_ZIP = WORKDIR_PATH + "/municipality.zip";
            FILE_TO_PARSE_PATH = WORKDIR_PATH + "/20210331_OB_573060_UZSZ.xml";
        } catch (MalformedURLException | URISyntaxException e) {
            throw new FileDownloadFailedException("URI is not valid", e);
        }
    }

    private final MunicipalityXMLParser municipalityXMLParser;

    private final MunicipalityMapper municipalityMapper;

    private final MunicipalityPartMapper municipalityPartMapper;

    private final MunicipalityRepository municipalityRepository;

    private final MunicipalityPartRepository municipalityPartRepository;

    @Override
    public void execute() {
        log.info("File fetching starting");
        FileUtils.getFileByUrlAndSave(URL_TO_MUNICIPALITY_FILE, WORKDIR_MUNICIPALITY_ZIP);
        log.info("File fetching finished");
        FileUtils.unzip(WORKDIR_MUNICIPALITY_ZIP, WORKDIR_PATH);
        try {
            Files.delete(Path.of(WORKDIR_MUNICIPALITY_ZIP));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        var result = municipalityXMLParser.parse(Path.of(FILE_TO_PARSE_PATH));
        log.info("Starting inserting municipalities to DB");
        result.municipalityDTOList()
                .stream()
                .map(municipalityMapper::toDAO)
                .forEach(municipalityRepository::save);
        log.info("Inserting municipalities to DB has been finished");

        log.info("Starting inserting municipality parts to DB");
        result.municipalityPartDTOList().stream()
                .map(municipalityPartDTO -> {
                    var mainMunicipality = municipalityRepository.findByCode(municipalityPartDTO.mainMunicipality());
                    var municipalityPartDAO = municipalityPartMapper.toDAO(municipalityPartDTO);
                    municipalityPartDAO.setMainMunicipality(mainMunicipality);
                    return municipalityPartDAO;
                })
                .forEach(municipalityPartRepository::save);
        log.info("Inserting municipality parts to DB has been finished");
    }
}

package org.castixz.municipalityimporter.tasks;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.castixz.municipalityimporter.enums.TaskResult;
import org.castixz.municipalityimporter.exceptions.FileDownloadFailedException;
import org.castixz.municipalityimporter.file.FileUtils;
import org.castixz.municipalityimporter.mapper.MunicipalityMapper;
import org.castixz.municipalityimporter.mapper.MunicipalityPartMapper;
import org.castixz.municipalityimporter.parser.MunicipalityParsingResult;
import org.castixz.municipalityimporter.parser.MunicipalityXMLParser;
import org.castixz.municipalityimporter.repository.MunicipalityPartRepository;
import org.castixz.municipalityimporter.repository.MunicipalityRepository;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;


@Component
@RequiredArgsConstructor
@Slf4j
public class ImportMunicipalityTask implements BatchTask {

    private static final String ZIP_FILE_NAME = "municipality.zip";

    private static final String XML_FILE_NAME = "20210331_OB_573060_UZSZ.xml";

    private static final URL URL_TO_MUNICIPALITY_FILE;

    private static final Path WORKDIR_PATH = Path.of(System.getProperty("user.dir") + "/workdir");

    static {
        try {
            URL_TO_MUNICIPALITY_FILE = URI.create("""
                    https://www.smartform.cz/download/kopidlno.xml.zip""").toURL();
        } catch (MalformedURLException e) {
            throw new FileDownloadFailedException("URI is not valid", e);
        }
    }

    private final MunicipalityXMLParser municipalityXMLParser;

    private final MunicipalityMapper municipalityMapper;

    private final MunicipalityPartMapper municipalityPartMapper;

    private final MunicipalityRepository municipalityRepository;

    private final MunicipalityPartRepository municipalityPartRepository;

    @Override
    public TaskResult execute() {
        try {
            this.preprocessTheFile();
            var result = municipalityXMLParser.parse(Path.of(WORKDIR_PATH.toString(), XML_FILE_NAME));
            this.saveToDB(result);
            return TaskResult.SUCCESSFUL;
        } catch (Exception e) {
            log.error("Task execution failed", e);
            return TaskResult.FAIL;
        }
    }

    @SneakyThrows
    void preprocessTheFile() {
        log.info("File fetching starting");
        var targetPathForMunicipalityZipFile = Path.of(WORKDIR_PATH.toString(), ZIP_FILE_NAME);
        FileUtils.getFileByUrlAndSave(URL_TO_MUNICIPALITY_FILE, targetPathForMunicipalityZipFile);
        log.info("File fetching finished");
        FileUtils.unzip(targetPathForMunicipalityZipFile.toString(), WORKDIR_PATH.toString());
    }

    void saveToDB(MunicipalityParsingResult result) {
        this.saveMunicipalitiesToDB(result);
        this.saveMunicipalityPartsToDB(result);
    }

    void saveMunicipalityPartsToDB(MunicipalityParsingResult result) {
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

    void saveMunicipalitiesToDB(MunicipalityParsingResult result) {
        log.info("Starting inserting municipalities to DB");
        result.municipalityDTOList()
                .stream()
                .map(municipalityMapper::toDAO)
                .forEach(municipalityRepository::save);
        log.info("Inserting municipalities to DB has been finished");
    }
}

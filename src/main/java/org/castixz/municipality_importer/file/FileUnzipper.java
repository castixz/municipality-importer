package org.castixz.municipality_importer.file;

import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import org.castixz.municipality_importer.exceptions.FileUnzipFailedException;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Slf4j
public class FileUnzipper {

    public void unzip(String zipFilePath, String targetDirectory) {
        try (var file = new ZipFile(zipFilePath)){
            log.info("Extracting content of {} to {}", zipFilePath, targetDirectory);
            file.extractAll(targetDirectory);
            log.info("Unzipping file done");
        } catch (IOException e) {
            throw new FileUnzipFailedException("File unzipping failed", e);
        }
    }
}

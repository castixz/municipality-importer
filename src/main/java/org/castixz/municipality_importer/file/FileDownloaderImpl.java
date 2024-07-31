package org.castixz.municipality_importer.file;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.castixz.municipality_importer.exceptions.FileDownloadFailedException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@Component
@Slf4j
public class FileDownloaderImpl implements FileDownloader {

    @Override
    public void getFileByUrlAndSave(URL fileUrl, String targetPath) {
        log.debug("Creating file {} to which remote file will be copied",targetPath);
        var outputFile = new File(targetPath);
        try {
            log.info("Fetching file from {} and writing into {}", fileUrl.getPath(), targetPath );
            FileUtils.copyURLToFile(fileUrl, outputFile);
            log.info("Fetching file done");
        } catch (IOException e) {
            throw new FileDownloadFailedException("Downloading file failed",e);
        }
    }
}

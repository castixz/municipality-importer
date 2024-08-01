package org.castixz.municipality_importer.file;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import net.lingala.zip4j.ZipFile;
import org.castixz.municipality_importer.exceptions.FileDownloadFailedException;
import org.castixz.municipality_importer.exceptions.FileUnzipFailedException;

import java.io.File;
import java.io.IOException;
import java.net.URL;

@UtilityClass
@Slf4j
public class FileUtils {

    public static void unzip(String zipFilePath, String targetDirectory) {
        try (var file = new ZipFile(zipFilePath)){
            log.info("Extracting content of {} to {}", zipFilePath, targetDirectory);
            file.extractAll(targetDirectory);
            log.info("Unzipping file done");
        } catch (IOException e) {
            throw new FileUnzipFailedException("File unzipping failed", e);
        }
    }

    public static void getFileByUrlAndSave(URL fileUrl, String targetPath) {
        log.debug("Creating file {} to which remote file will be copied",targetPath);
        var outputFile = new File(targetPath);
        try {
            log.info("Fetching file from {} and writing into {}", fileUrl.getPath(), targetPath );
            org.apache.commons.io.FileUtils.copyURLToFile(fileUrl, outputFile);
            log.info("Fetching file done");
        } catch (IOException e) {
            throw new FileDownloadFailedException("Downloading file failed",e);
        }
    }
}

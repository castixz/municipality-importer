package org.castixz.municipality_importer.file;

import java.net.URL;

public interface FileDownloader {

    void getFileByUrlAndSave(URL fileUrl, String targetPath);
}

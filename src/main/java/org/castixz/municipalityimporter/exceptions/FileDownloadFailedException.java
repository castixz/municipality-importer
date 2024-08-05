package org.castixz.municipalityimporter.exceptions;

public class FileDownloadFailedException extends RuntimeException {

    public FileDownloadFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}

package org.castixz.municipality_importer.exceptions;

public class FileUnzipFailedException extends RuntimeException{

    public FileUnzipFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}

package org.castixz.municipalityimporter.exceptions;

public class FileUnzipFailedException extends RuntimeException{

    public FileUnzipFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}

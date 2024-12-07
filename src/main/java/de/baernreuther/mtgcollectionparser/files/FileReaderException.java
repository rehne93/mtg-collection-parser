package de.baernreuther.mtgcollectionparser.files;

import java.io.FileReader;

public class FileReaderException extends Exception {

    public FileReaderException(String msg, Throwable cause) {
        super(msg, cause);
    }
}

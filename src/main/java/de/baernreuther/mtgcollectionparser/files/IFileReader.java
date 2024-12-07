package de.baernreuther.mtgcollectionparser.files;

import de.baernreuther.mtgcollectionparser.files.model.InputCard;

import java.util.List;

public interface IFileReader {

    /**
     * Parses the given filepath to any file and converts it to InputCard-Objects
     * @param filepath Filepath on your local filesystem
     * @return List of Cards as InputCard
     */
    List<InputCard> parse(String filepath) throws FileReaderException;
}

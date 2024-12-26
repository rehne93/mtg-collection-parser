package de.baernreuther.mtgcollectionparser;

import de.baernreuther.mtgcollectionparser.command.GenerateReportCommand;
import de.baernreuther.mtgcollectionparser.files.FileReaderException;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallClientException;
import de.baernreuther.mtgcollectionparser.writer.FileWriterException;
import picocli.CommandLine;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileReaderException, FileWriterException, FileNotFoundException, ScryfallClientException {
        int exitCode = new CommandLine(new GenerateReportCommand()).execute(args);
        System.exit(exitCode);
    }
}
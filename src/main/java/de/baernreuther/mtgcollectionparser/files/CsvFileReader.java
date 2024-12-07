package de.baernreuther.mtgcollectionparser.files;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import de.baernreuther.mtgcollectionparser.files.model.InputCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements IFileReader {

    private final String DELIMITER = ";";

    @Override
    public List<InputCard> parse(String filepath) throws FileReaderException {
        var inputCardList = new ArrayList<InputCard>();

        try (Reader reader = Files.newBufferedReader(Path.of(filepath))) {
            try (CSVReader csvReader = new CSVReader(reader)) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    if (line.length < 3) {
                        throw new FileReaderException("Line not long enough", null);
                    }

                    inputCardList.add(new InputCard(line[0], line[1], line[2]));
                }
            } catch (IOException | CsvValidationException e) {
                throw new FileReaderException("Could not parse line", e);
            }
        } catch (IOException e) {
            throw new FileReaderException("Could not open file", e);
        }


        return inputCardList;
    }

}

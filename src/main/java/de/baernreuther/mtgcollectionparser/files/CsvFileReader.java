package de.baernreuther.mtgcollectionparser.files;

import de.baernreuther.mtgcollectionparser.files.model.InputCard;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvFileReader implements IFileReader {

    private final String DELIMITER = ";";

    @Override
    public List<InputCard> parse(String filepath) throws FileReaderException {

        var inputCardList = new ArrayList<InputCard>();
        int lineCount = 1;
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(DELIMITER);
                if (values.length < 3) {
                    throw new FileReaderException("Card on line " + lineCount + " not complete", null);
                }

                var inputCard = new InputCard(this.removeDoubleQuotes(values[0]), this.removeDoubleQuotes(values[1]), this.removeDoubleQuotes(values[2]));
                inputCardList.add(inputCard);
                lineCount++;
            }
        } catch (IOException e) {
            throw new FileReaderException("Could not parse file " + filepath, e);
        }
        return inputCardList;
    }

    private String removeDoubleQuotes(String input) {
        return input.replace("\"", "");
    }
}

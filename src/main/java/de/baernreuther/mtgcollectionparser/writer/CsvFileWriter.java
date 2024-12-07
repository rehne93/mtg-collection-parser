package de.baernreuther.mtgcollectionparser.writer;

import com.opencsv.CSVWriter;
import de.baernreuther.mtgcollectionparser.scryfall.model.Card;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class CsvFileWriter implements IFileWriter {
    @Override
    public void writeFile(List<Card> cards, String filePath) throws FileWriterException {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            for (Card c : cards) {
                csvWriter.writeNext(this.convertToArray(c));
            }
        } catch (IOException e) {
            throw new FileWriterException("Could not write csv", e);
        }
    }

    private String[] convertToArray(Card c) {
        return new String[]{
                c.getName(),
                c.getRarity(),
                c.getSet(),
                c.getPrices().getEur()
        };
    }
}

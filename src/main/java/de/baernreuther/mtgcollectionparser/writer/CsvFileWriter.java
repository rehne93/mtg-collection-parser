package de.baernreuther.mtgcollectionparser.writer;

import com.opencsv.CSVWriter;
import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;
import org.apache.commons.lang3.StringUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

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
        String price = c.getPrices().getEur() != null ? c.getPrices().getEur().replace(".", ",") : "";

        return new String[]{
                c.getName(),
                StringUtils.capitalize(c.getRarity()),
                c.getSet().toUpperCase(Locale.ROOT),
                price
        };
    }
}

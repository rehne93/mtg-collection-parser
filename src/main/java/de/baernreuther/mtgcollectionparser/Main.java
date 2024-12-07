package de.baernreuther.mtgcollectionparser;

import de.baernreuther.mtgcollectionparser.files.CsvFileReader;
import de.baernreuther.mtgcollectionparser.files.FileReaderException;
import de.baernreuther.mtgcollectionparser.files.IFileReader;
import de.baernreuther.mtgcollectionparser.files.model.InputCard;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallClient;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallClientException;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallQuery;
import de.baernreuther.mtgcollectionparser.scryfall.model.Card;
import de.baernreuther.mtgcollectionparser.writer.CsvFileWriter;
import de.baernreuther.mtgcollectionparser.writer.FileWriterException;
import de.baernreuther.mtgcollectionparser.writer.IFileWriter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    private final static String FILEPATH = "mtg.csv";


    public static void main(String[] args) throws FileReaderException, FileWriterException {

        IFileReader fileReader = new CsvFileReader();
        ScryfallClient scryfallClient = new ScryfallClient();

        var cards = fileReader.parse(FILEPATH);
        System.out.print("Size of file:" + cards.size());

        List<Card> cardresult = new ArrayList<>();

        var lineCount = 0;
        for (InputCard card : cards) {
            var query = ScryfallQuery.build().setCardName(card.cardName()).setLanguage(card.language());
            Card cardResponse = null;
            try {
                cardResponse = scryfallClient.fetchCard(query);
            } catch (ScryfallClientException e) {
                System.err.println("Error while fetching " + query);
            }
            if (cardResponse != null) {
                cardresult.add(cardResponse);
            }
            System.out.print(lineCount+1 + "/" + cards.size());
            lineCount++;
        }

        // Liste nach Namen ordnen
        cardresult.sort(Comparator.comparing(Card::getName));

        IFileWriter writer = new CsvFileWriter();
        writer.writeFile(cardresult, "result.csv");
    }
}
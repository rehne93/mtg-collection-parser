package de.baernreuther.mtgcollectionparser;

import de.baernreuther.mtgcollectionparser.files.CsvFileReader;
import de.baernreuther.mtgcollectionparser.files.FileReaderException;
import de.baernreuther.mtgcollectionparser.files.IFileReader;
import de.baernreuther.mtgcollectionparser.files.model.InputCard;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallClient;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallClientException;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallQuery;
import de.baernreuther.mtgcollectionparser.scryfall.model.Card;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private final static String FILEPATH = "mtg.csv";


    public static void main(String[] args) throws FileReaderException, ScryfallClientException {

        IFileReader fileReader = new CsvFileReader();
        ScryfallClient scryfallClient = new ScryfallClient();

        var cards = fileReader.parse(FILEPATH);

        List<Card> cardresult = new ArrayList<>();

        for (InputCard card : cards) {
            var query = ScryfallQuery.build().addCardName(card.cardName()).addLanguage(card.language());
            System.out.println(query);
            var cardResponse = scryfallClient.fetchCard(query);
            cardresult.add(cardResponse);
        }

        return;

    }
}
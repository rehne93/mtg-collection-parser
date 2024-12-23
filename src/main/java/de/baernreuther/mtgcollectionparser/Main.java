package de.baernreuther.mtgcollectionparser;

import de.baernreuther.mtgcollectionparser.bulk.BulkDataReader;
import de.baernreuther.mtgcollectionparser.bulk.BulkDataWriter;
import de.baernreuther.mtgcollectionparser.files.CsvFileReader;
import de.baernreuther.mtgcollectionparser.files.FileReaderException;
import de.baernreuther.mtgcollectionparser.files.IFileReader;
import de.baernreuther.mtgcollectionparser.files.model.InputCard;
import de.baernreuther.mtgcollectionparser.scryfall.*;
import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;
import de.baernreuther.mtgcollectionparser.writer.CsvFileWriter;
import de.baernreuther.mtgcollectionparser.writer.FileWriterException;
import de.baernreuther.mtgcollectionparser.writer.IFileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    private final static String FILEPATH = "mtg.csv";


    public static void main(String[] args) throws FileReaderException, FileWriterException, FileNotFoundException, ScryfallClientException {
        String filePath = FILEPATH;

        if (args.length > 1) {
            filePath = args[0];
        }

        ScryfallApiClient bulkClient = new ScryfallApiClient();
        var uri = bulkClient.fetchBulkUri();

        BulkDataWriter bulkDataWriter = new BulkDataWriter();
        var file = bulkDataWriter.saveBulkdata(uri);

        BulkDataReader bulkDataReader = new BulkDataReader();
        var result = bulkDataReader.parseCards(file);


        IFileReader fileReader = new CsvFileReader();
        var cards = fileReader.parse(filePath);
        System.out.print("Size of file:" + cards.size());

        List<Card> cardresult = new ArrayList<>();

        var lineCount = 0;

        IScryfallClient scryfallClient = new BulkDataScryfallClient(result);
        for (InputCard card : cards) {
            var query = ScryfallQuery.build().setCardName(card.cardName()).setLanguage(card.language()).setSet(card.set());
            Card cardResponse;
            cardResponse = scryfallClient.fetchCard(query);

            if (cardResponse != null) {
                cardresult.add(cardResponse);
            }
//            System.out.println(lineCount + 1 + "/" + cards.size());
            lineCount++;
        }

        // Liste nach Namen ordnen
        cardresult.sort(Comparator.comparing(Card::getName));

        IFileWriter writer = new CsvFileWriter();
        writer.writeFile(cardresult, "result.csv");

        File f = new File("test.json");
        f.delete();
    }
}
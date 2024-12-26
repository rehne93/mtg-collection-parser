package de.baernreuther.mtgcollectionparser.command;


import de.baernreuther.mtgcollectionparser.bulk.BulkDataReader;
import de.baernreuther.mtgcollectionparser.bulk.BulkDataWriter;
import de.baernreuther.mtgcollectionparser.files.CsvFileReader;
import de.baernreuther.mtgcollectionparser.files.IFileReader;
import de.baernreuther.mtgcollectionparser.files.model.InputCard;
import de.baernreuther.mtgcollectionparser.scryfall.BulkDataScryfallClient;
import de.baernreuther.mtgcollectionparser.scryfall.IScryfallClient;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallApiClient;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallQuery;
import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;
import de.baernreuther.mtgcollectionparser.writer.CsvFileWriter;
import de.baernreuther.mtgcollectionparser.writer.HtmlFileWriter;
import de.baernreuther.mtgcollectionparser.writer.IFileWriter;
import picocli.CommandLine;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "report", mixinStandardHelpOptions = true,
        description = "Creates an invidivual report for your mtg collection")
public class GenerateReportCommand implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "Filepath for your input file", defaultValue = "mtg.csv")
    private String inputPath = "mtg.csv";

    @CommandLine.Option(names = {"-f", "--format"}, description = "HTML, CSV")
    private String format = "HTML";

    @CommandLine.Option(names = {"-o", "--output"}, description = "Output-File-Name without fileending")
    private String outputFileName = "result";

    @CommandLine.Option(names = {"-d", "--delete"}, description = "Delete scryfall bulk afterwards")
    private boolean deleteScryfall = false;

    @Override
    public Integer call() throws Exception {

        ScryfallApiClient bulkClient = new ScryfallApiClient();
        var bulkUri = bulkClient.fetchBulkUri();

        BulkDataWriter bulkDataWriter = new BulkDataWriter();
        var bulkDataFile = bulkDataWriter.saveBulkdata(bulkUri);

        BulkDataReader bulkDataReader = new BulkDataReader();
        var parsedCards = bulkDataReader.parseCards(bulkDataFile);

        IFileReader fileReader = new CsvFileReader();
        var cards = fileReader.parse(this.inputPath);

        List<Card> mappedCards = new ArrayList<>();

        IScryfallClient scryfallClient = new BulkDataScryfallClient(parsedCards);
        for (InputCard card : cards) {
            var query = ScryfallQuery.build().setCardName(card.cardName()).setLanguage(card.language()).setSet(card.set());
            Card cardResponse = scryfallClient.fetchCard(query);

            if (cardResponse != null) {
                mappedCards.add(cardResponse);
            }
        }

        // Liste nach Namen ordnen
        mappedCards.sort(Comparator.comparing(Card::getName));

        // Output
        if (this.format.toLowerCase(Locale.ROOT).contains("html")) {
            IFileWriter writer = new HtmlFileWriter();
            writer.writeFile(mappedCards, this.outputFileName);
        }

        if (this.format.toLowerCase(Locale.ROOT).contains("csv")) {
            IFileWriter writer = new CsvFileWriter();
            writer.writeFile(mappedCards, this.outputFileName);
        }

        if (this.deleteScryfall) {
            File f = new File(bulkDataFile);
            f.delete();
        }


        return 0;
    }
}

package de.baernreuther.mtgcollectionparser.scryfall;

import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;

import java.util.List;

public class BulkDataScryfallClient implements IScryfallClient {

    private final List<Card> cardDatabase;

    public BulkDataScryfallClient(List<Card> cardList) {
        this.cardDatabase = cardList;
    }

    @Override
    public Card fetchCard(ScryfallQuery query) throws ScryfallClientException {
        var match = this.searchFor(query.getCardName(), query.getSet(), query.getLang());

        if (match == null) {
            System.err.println("Error for " + query.getCardName());
            return null;
        }
        if (!query.isEnglish()) {
            match = searchFor(match.getName(), query.getSet(), "en");
        }
        return match;

    }

    private Card searchFor(String cardName, String set, String lang) {
        cardName = cardName.toLowerCase().trim();
        for (Card c : cardDatabase) {
            String nameOfCard = c.getName().toLowerCase();
            String printedName = c.getPrinted_name() != null ? c.getPrinted_name().toLowerCase() : "";

            if ((printedName.contains(cardName) ||
                    nameOfCard.contains(cardName)
                            && set.equalsIgnoreCase(c.getSet())
                            && lang.equalsIgnoreCase(c.getLang()))) {
                return c;
            }
        }

        return null;
    }
}

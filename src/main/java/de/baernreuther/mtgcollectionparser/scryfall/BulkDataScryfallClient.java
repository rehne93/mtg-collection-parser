package de.baernreuther.mtgcollectionparser.scryfall;

import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;
import de.baernreuther.mtgcollectionparser.scryfall.model.card.Prices;

import java.util.List;

public class BulkDataScryfallClient implements IScryfallClient {

    private final List<Card> cardDatabase;

    public BulkDataScryfallClient(List<Card> cardList) {
        this.cardDatabase = cardList;
    }

    @Override
    public Card fetchCard(ScryfallQuery query) throws ScryfallClientException {
        var firstMatch = this.searchFor(query.getCardName(), query.getSet(), query.getLang());

        if (firstMatch == null) {
            System.err.println("Error for " + query.getCardName());
            return this.buildDummyCard(query);
        }
        if (!query.isEnglish()) {
            var englishMatch = searchFor(firstMatch.getName(), query.getSet(), "en");
            if (englishMatch == null) {
                System.err.println("Error for english " + query.getCardName());
                return firstMatch;
            }
            englishMatch.setPrinted_name(query.getCardName());
            return englishMatch;
        }
        return firstMatch;

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

    private Card buildDummyCard(ScryfallQuery scryfallQuery) {
        var card = new Card();
        if (!"EN".equalsIgnoreCase(scryfallQuery.getLang())) {
            card.setPrinted_name(scryfallQuery.getCardName());
        }
        card.setSet(scryfallQuery.getSet());
        card.setName(scryfallQuery.getCardName());
        card.setLang(scryfallQuery.getLang());
        card.setPrices(new Prices());
        return card;
    }
}

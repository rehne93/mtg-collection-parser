package de.baernreuther.mtgcollectionparser.scryfall;

import de.baernreuther.mtgcollectionparser.scryfall.model.Card;

import java.util.ArrayList;
import java.util.List;

public class LocalScryfallClient implements IScryfallClient {

    private final List<Card> cardDatabase;

    public LocalScryfallClient(List<Card> cardList) {
        this.cardDatabase = cardList;
    }

    @Override
    public Card fetchCard(ScryfallQuery query) throws ScryfallClientException {
        var match = this.searchFor(query.getCardName(), query.getSet(), query.getLang());

        if (match == null) {
            return null;
        }
        if (!query.isEnglish()) {
            match = searchFor(match.getName(), query.getSet(), "en");
        }
        return match;

    }

    private Card searchFor(String cardName, String set, String lang) {
        for (Card c : cardDatabase) {
            if ((cardName.equalsIgnoreCase(c.getPrinted_name()) ||
                    cardName.equalsIgnoreCase(c.getName()))
            && set.equalsIgnoreCase(c.getSet())
            && lang.equalsIgnoreCase(c.getLang())) {
                return c;
            }
        }

        return null;
    }
}

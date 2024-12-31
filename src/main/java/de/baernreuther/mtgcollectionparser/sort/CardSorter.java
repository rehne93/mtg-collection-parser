package de.baernreuther.mtgcollectionparser.sort;

import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;

import java.util.Comparator;
import java.util.List;

public class CardSorter {


    public List<Card> sortCards(String orderType, List<Card> cards) {
        if (orderType.equalsIgnoreCase("name")) {
            // Liste nach Namen ordnen
            cards.sort(Comparator.comparing(Card::getName));
        }

        if (orderType.equalsIgnoreCase("set")) {
            cards.sort(Comparator.comparing(Card::getSet));
        }

        if (orderType.equalsIgnoreCase("price")) {
            cards.sort((c1, c2) -> {
                return Double.compare(c2.getPrices().getEur(), c1.getPrices().getEur());
            });
        }

        return cards;
    }
}

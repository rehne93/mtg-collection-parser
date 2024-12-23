package de.baernreuther.mtgcollectionparser.scryfall;

import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;

public interface IScryfallClient {


    Card fetchCard(ScryfallQuery query) throws ScryfallClientException;

}


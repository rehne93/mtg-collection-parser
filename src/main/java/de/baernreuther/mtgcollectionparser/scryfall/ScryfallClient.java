package de.baernreuther.mtgcollectionparser.scryfall;

import de.baernreuther.mtgcollectionparser.scryfall.client.CardClient;
import de.baernreuther.mtgcollectionparser.scryfall.client.ScryfallClientErrorDecoder;
import de.baernreuther.mtgcollectionparser.scryfall.model.Card;
import de.baernreuther.mtgcollectionparser.scryfall.model.SearchResponse;
import feign.Feign;
import feign.gson.GsonDecoder;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ScryfallClient {


    private CardClient cardClient;
    private int delayInMs = 100;

    private Map<String, Card> foundCards = new ConcurrentHashMap<>();

    public ScryfallClient() {
        this.cardClient = Feign.builder()
                .decoder(new GsonDecoder())
                .errorDecoder(new ScryfallClientErrorDecoder())
                .target(CardClient.class, "https://api.scryfall.com");
    }


    public Card fetchCard(ScryfallQuery query) throws ScryfallClientException {

        // Caching
        if (this.foundCards.containsKey(query.getQuery())) {
            return this.foundCards.get(query.getQuery());
        }

        // Sleep for scryfall api
        try {
            Thread.sleep(this.delayInMs);
        } catch (InterruptedException e) {
            throw new ScryfallClientException("Could not sleep " + this.delayInMs, e);
        }


        // Building request and fetching data
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("q", query.getQuery());

        SearchResponse result = null;
        try {
            result = this.cardClient.search(queryMap);
        } catch (ScryfallClientException exception) {
            System.err.println("Error executing request " + exception.getMessage());
            return null;
        }

        // validating
        if (result == null) {
            throw new ScryfallClientException("Could not fetch carddata for " + query, null);
        }

        if (result.getData().isEmpty()) {
            throw new ScryfallClientException("No card found for " + query, null);
        }

        var cardResult = result.getData().getFirst();

        // Caching
        this.foundCards.put(query.getQuery(), cardResult);

        // Falls DE Suche -> Englisch dazu suchen
        if (!cardResult.getLang().equalsIgnoreCase("en")) {
            query.setCardName(cardResult.getName());
            query.setLanguage("EN");
            return this.fetchCard(query);
        }

        return cardResult;
    }


}

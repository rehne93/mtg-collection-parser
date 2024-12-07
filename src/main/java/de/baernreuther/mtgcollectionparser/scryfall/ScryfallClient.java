package de.baernreuther.mtgcollectionparser.scryfall;

import de.baernreuther.mtgcollectionparser.scryfall.client.CardClient;
import de.baernreuther.mtgcollectionparser.scryfall.model.Card;
import feign.Feign;
import feign.gson.GsonDecoder;

import java.util.HashMap;
import java.util.Map;

public class ScryfallClient {


    private CardClient cardClient;
    private int delayInMs = 100;

    public ScryfallClient() {
        this.cardClient = Feign.builder()
                .decoder(new GsonDecoder())
                .target(CardClient.class, "https://api.scryfall.com");
    }


    public Card fetchCard(ScryfallQuery query) throws ScryfallClientException {
        try {
            Thread.sleep(this.delayInMs);
        } catch (InterruptedException e) {
            throw new ScryfallClientException("Could not sleep " + this.delayInMs, e);
        }

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("q", query.getQuery());

        var result = this.cardClient.search(queryMap);

        if (result == null) {
            throw new ScryfallClientException("Could not fetch carddata for " + query, null);
        }

        if (result.getData().isEmpty()) {
            throw new ScryfallClientException("No card found for " + query, null);
        }

        return result.getData().getFirst();
    }


}

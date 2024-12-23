package de.baernreuther.mtgcollectionparser.scryfall;

import de.baernreuther.mtgcollectionparser.scryfall.model.bulk.DataItem;
import de.baernreuther.mtgcollectionparser.scryfall.client.CardClient;
import de.baernreuther.mtgcollectionparser.scryfall.client.ScryfallClientErrorDecoder;
import feign.Feign;
import feign.gson.GsonDecoder;

public class ScryfallApiClient {


    private final CardClient cardClient;


    public ScryfallApiClient() {
        this.cardClient = Feign.builder()
                .decoder(new GsonDecoder())
                .errorDecoder(new ScryfallClientErrorDecoder())
                .target(CardClient.class, "https://api.scryfall.com");
    }

    public String fetchBulkUri() throws ScryfallClientException {
        var response = this.cardClient.getBulkData();

        for(DataItem i : response.getData()) {
            if("all_cards".equalsIgnoreCase(i.getType())) {
                return i.getDownload_uri();
            }
        }
        return null;
    }


}

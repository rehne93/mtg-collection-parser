package de.baernreuther.mtgcollectionparser.scryfall.client;

import de.baernreuther.mtgcollectionparser.scryfall.ScryfallClientException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class ScryfallClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        if (response.status() >= 400) {
            System.err.println("Error executing request " + response.reason() + " " + response.request().url());
        }
        return new ScryfallClientException("Found nothing for url " + response.reason() + " " + response.request().url(),
                null);
    }
}

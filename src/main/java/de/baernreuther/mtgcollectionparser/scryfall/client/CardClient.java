package de.baernreuther.mtgcollectionparser.scryfall.client;

import de.baernreuther.mtgcollectionparser.scryfall.bulkmodel.BulkInfoResponse;
import de.baernreuther.mtgcollectionparser.scryfall.ScryfallClientException;
import de.baernreuther.mtgcollectionparser.scryfall.model.SearchResponse;
import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface CardClient {

    @RequestLine("GET /cards/search")
    SearchResponse search(@QueryMap Map<String, String> searchParams) throws ScryfallClientException;

    @RequestLine("GET /bulk-data")
    BulkInfoResponse getBulkData() throws ScryfallClientException;
}

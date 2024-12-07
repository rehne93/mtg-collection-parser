package de.baernreuther.mtgcollectionparser.scryfall.model;

import java.util.List;

public class SearchResponse {
    private String nextPage;
    private int totalCards;
    private List<Card> data;
    private boolean hasMore;
    private String object;

    public String getNextPage() {
        return nextPage;
    }

    public int getTotalCards() {
        return totalCards;
    }

    public List<Card> getData() {
        return data;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public String getObject() {
        return object;
    }
}
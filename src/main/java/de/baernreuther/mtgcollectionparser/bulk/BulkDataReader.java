package de.baernreuther.mtgcollectionparser.bulk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class BulkDataReader {

    private static final Type REVIEW_TYPE = new TypeToken<List<Card>>() {
    }.getType();
    private List<String> languagesToUse = List.of("de", "en");

    public List<Card> parseCards(String fileName) throws FileNotFoundException {
        List<Card> allCards;
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader(fileName));

        allCards = gson.fromJson(jsonReader, REVIEW_TYPE);


        List<Card> filteredCards = new ArrayList<>();

        for (Card c : allCards) {
            if (languagesToUse.contains(c.getLang())) {
                filteredCards.add(c);
            }
        }
        return filteredCards;
    }
}

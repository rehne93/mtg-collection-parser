package de.baernreuther.mtgcollectionparser.bulk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import de.baernreuther.mtgcollectionparser.scryfall.model.Card;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class BulkDataReader {

    private static final Type REVIEW_TYPE = new TypeToken<List<Card>>() {
    }.getType();

    public List<Card> parseCards(String fileName) throws FileNotFoundException {
        List<Card> cards;
        Gson gson = new Gson();
        JsonReader jsonReader = new JsonReader(new FileReader(fileName));

        cards = gson.fromJson(jsonReader, REVIEW_TYPE);
        return cards;
    }
}

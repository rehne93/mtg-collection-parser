package de.baernreuther.mtgcollectionparser.writer;

import de.baernreuther.mtgcollectionparser.scryfall.model.card.Card;

import java.util.List;

public interface IFileWriter {


    void writeFile(List<Card> cards, String filePath) throws FileWriterException;
}

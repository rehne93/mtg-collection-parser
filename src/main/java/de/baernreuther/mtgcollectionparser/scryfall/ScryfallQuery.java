package de.baernreuther.mtgcollectionparser.scryfall;

public class ScryfallQuery {

    private String query;

    private ScryfallQuery() {
        this.query = "";
    }

    String getQuery() {
        return this.query;
    }

    public static ScryfallQuery build() {
        return new ScryfallQuery();
    }

    public ScryfallQuery addCardName(String cardName) {
        this.query += "!" + "\"" + cardName + "\"";
        return this.addWhiteSpace();
    }


    public ScryfallQuery addGamePaper() {
        this.query += "(game:paper)";
        return this.addWhiteSpace();
    }

    public ScryfallQuery addLanguage(String languageShorthand) {
        this.query += "lang:" + languageShorthand;
        return this.addWhiteSpace();
    }

    private ScryfallQuery addWhiteSpace() {
        this.query += " ";
        return this;
    }

    @Override
    public String toString() {
        return this.query;
    }

}

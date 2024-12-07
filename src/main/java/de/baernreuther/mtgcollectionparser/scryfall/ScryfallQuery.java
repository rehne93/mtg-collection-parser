package de.baernreuther.mtgcollectionparser.scryfall;

public class ScryfallQuery {

    private String lang = "";
    private String game = "";
    private String cardName = "";

    private ScryfallQuery() {
    }

    String getQuery() {
        return this.cardName + " " + this.game + " " + this.lang;
    }

    public static ScryfallQuery build() {
        return new ScryfallQuery();
    }

    public ScryfallQuery setCardName(String cardName) {
        this.cardName = "!" + "\"" + cardName + "\"";
        return this;
    }

    public ScryfallQuery setGamePaper() {
        this.game = "(game:paper)";
        return this;
    }

    public ScryfallQuery setLanguage(String languageShorthand) {
        this.lang = "lang:" + languageShorthand;
        return this;
    }

    public boolean isEnglish() {
        return "lang:en".equalsIgnoreCase(this.lang);
    }


    @Override
    public String toString() {
        return this.getQuery();
    }

}

package de.baernreuther.mtgcollectionparser.scryfall;

public class ScryfallQuery {

    private String lang = "";
    private String game = "";
    private String cardName = "";
    private String set = "";

    private ScryfallQuery() {
    }

    public static ScryfallQuery build() {
        return new ScryfallQuery();
    }

    String getQuery() {
        return "!" + "\"" + this.cardName + "\"" + " " + this.game + " " + "lang:" + this.lang;
    }

    public ScryfallQuery setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public ScryfallQuery setGamePaper() {
        this.game = "(game:paper)";
        return this;
    }

    public ScryfallQuery setLanguage(String languageShorthand) {
        this.lang = languageShorthand;
        return this;
    }

    public boolean isEnglish() {
        return "en".equalsIgnoreCase(this.lang);
    }

    public String getLang() {
        return lang;
    }

    public String getGame() {
        return game;
    }

    public String getCardName() {
        return cardName;
    }

    public String getSet() {
        return set;
    }

    public ScryfallQuery setSet(String set) {
        this.set = set;
        return this;
    }

    @Override
    public String toString() {
        return this.getQuery();
    }

}

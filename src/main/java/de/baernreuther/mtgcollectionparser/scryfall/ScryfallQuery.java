package de.baernreuther.mtgcollectionparser.scryfall;

public class ScryfallQuery {

    private String lang = "";
    private String cardName = "";
    private String set = "";

    private ScryfallQuery() {
    }

    public static ScryfallQuery build() {
        return new ScryfallQuery();
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

    public String getCardName() {
        return cardName;
    }

    public ScryfallQuery setCardName(String cardName) {
        this.cardName = cardName;
        return this;
    }

    public String getSet() {
        return set;
    }

    public ScryfallQuery setSet(String set) {
        this.set = set;
        return this;
    }
}

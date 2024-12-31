package de.baernreuther.mtgcollectionparser.scryfall.model.card;

public class Prices {
    private String usdFoil;
    private Object usdEtched;
    private String tix;
    private String eur;
    private String usd;
    private String eurFoil;

    public String getUsdFoil() {
        return usdFoil;
    }

    public Object getUsdEtched() {
        return usdEtched;
    }

    public String getTix() {
        return tix;
    }

    public double getEur() {
        if (eur == null) {
            return 0;
        }
        return Double.parseDouble(eur);
    }

    public String getUsd() {
        return usd;
    }

    public String getEurFoil() {
        return eurFoil;
    }
}

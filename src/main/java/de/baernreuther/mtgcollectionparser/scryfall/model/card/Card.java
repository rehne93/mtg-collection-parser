package de.baernreuther.mtgcollectionparser.scryfall.model.card;

import java.util.List;

public class Card {
    private List<Object> keywords;
    private String oracleText;
    private int tcgplayerId;
    private String printsSearchUri;
    private boolean variation;
    private String setSearchUri;
    private String flavorText;
    private String setName;
    private String scryfallUri;
    private int edhrecRank;
    private String manaCost;
    private List<String> games;
    private String setId;
    private String id;
    private String toughness;
    private boolean foil;
    private PurchaseUris purchaseUris;
    private String scryfallSetUri;
    private String watermark;
    private String typeLine;
    private List<String> colorIdentity;
    private String setType;
    private RelatedUris relatedUris;
    private Legalities legalities;
    private String borderColor;
    private int mtgoFoilId;
    private int cardmarketId;
    private boolean reserved;
    private String name;
    private String printed_name;
    private Object cmc;
    private String object;
    private String rarity;
    private String frame;
    private String oracleId;
    private String artist;
    private String releasedAt;
    private List<String> colors;
    private boolean booster;
    private String illustrationId;
    private boolean promo;
    private List<String> artistIds;
    private int mtgoId;
    private String rulingsUri;
    private String collectorNumber;
    private List<String> finishes;
    private String setUri;
    private String power;
    private String lang;
    private Prices prices;
    private boolean highresImage;
    private boolean digital;
    private String set;
    private boolean reprint;
    private boolean fullArt;
    private ImageUris image_uris;
    private boolean nonfoil;
    private String cardBackId;
    private String uri;
    private String layout;
    private List<Integer> multiverseIds;
    private boolean oversized;
    private boolean storySpotlight;
    private String imageStatus;
    private boolean textless;
    private int arenaId;
    private List<String> frameEffects;
    private int pennyRank;
    private Preview preview;
    private String securityStamp;
    private List<String> promoTypes;
    private List<AllPartsItem> allParts;
    private List<CardFacesItem> cardFaces;
    private List<String> producedMana;
    private List<String> colorIndicator;

    public List<Object> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Object> keywords) {
        this.keywords = keywords;
    }

    public String getOracleText() {
        return oracleText;
    }

    public void setOracleText(String oracleText) {
        this.oracleText = oracleText;
    }

    public int getTcgplayerId() {
        return tcgplayerId;
    }

    public void setTcgplayerId(int tcgplayerId) {
        this.tcgplayerId = tcgplayerId;
    }

    public String getPrintsSearchUri() {
        return printsSearchUri;
    }

    public void setPrintsSearchUri(String printsSearchUri) {
        this.printsSearchUri = printsSearchUri;
    }

    public boolean isVariation() {
        return variation;
    }

    public void setVariation(boolean variation) {
        this.variation = variation;
    }

    public String getSetSearchUri() {
        return setSearchUri;
    }

    public void setSetSearchUri(String setSearchUri) {
        this.setSearchUri = setSearchUri;
    }

    public String getFlavorText() {
        return flavorText;
    }

    public void setFlavorText(String flavorText) {
        this.flavorText = flavorText;
    }

    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public String getScryfallUri() {
        return scryfallUri;
    }

    public void setScryfallUri(String scryfallUri) {
        this.scryfallUri = scryfallUri;
    }

    public int getEdhrecRank() {
        return edhrecRank;
    }

    public void setEdhrecRank(int edhrecRank) {
        this.edhrecRank = edhrecRank;
    }

    public String getManaCost() {
        return manaCost;
    }

    public void setManaCost(String manaCost) {
        this.manaCost = manaCost;
    }

    public List<String> getGames() {
        return games;
    }

    public void setGames(List<String> games) {
        this.games = games;
    }

    public String getSetId() {
        return setId;
    }

    public void setSetId(String setId) {
        this.setId = setId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToughness() {
        return toughness;
    }

    public void setToughness(String toughness) {
        this.toughness = toughness;
    }

    public boolean isFoil() {
        return foil;
    }

    public void setFoil(boolean foil) {
        this.foil = foil;
    }

    public PurchaseUris getPurchaseUris() {
        return purchaseUris;
    }

    public void setPurchaseUris(PurchaseUris purchaseUris) {
        this.purchaseUris = purchaseUris;
    }

    public String getScryfallSetUri() {
        return scryfallSetUri;
    }

    public void setScryfallSetUri(String scryfallSetUri) {
        this.scryfallSetUri = scryfallSetUri;
    }

    public String getWatermark() {
        return watermark;
    }

    public void setWatermark(String watermark) {
        this.watermark = watermark;
    }

    public String getTypeLine() {
        return typeLine;
    }

    public void setTypeLine(String typeLine) {
        this.typeLine = typeLine;
    }

    public List<String> getColorIdentity() {
        return colorIdentity;
    }

    public void setColorIdentity(List<String> colorIdentity) {
        this.colorIdentity = colorIdentity;
    }

    public String getSetType() {
        return setType;
    }

    public void setSetType(String setType) {
        this.setType = setType;
    }

    public RelatedUris getRelatedUris() {
        return relatedUris;
    }

    public void setRelatedUris(RelatedUris relatedUris) {
        this.relatedUris = relatedUris;
    }

    public Legalities getLegalities() {
        return legalities;
    }

    public void setLegalities(Legalities legalities) {
        this.legalities = legalities;
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
    }

    public int getMtgoFoilId() {
        return mtgoFoilId;
    }

    public void setMtgoFoilId(int mtgoFoilId) {
        this.mtgoFoilId = mtgoFoilId;
    }

    public int getCardmarketId() {
        return cardmarketId;
    }

    public void setCardmarketId(int cardmarketId) {
        this.cardmarketId = cardmarketId;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getCmc() {
        return cmc;
    }

    public void setCmc(Object cmc) {
        this.cmc = cmc;
    }

    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getOracleId() {
        return oracleId;
    }

    public void setOracleId(String oracleId) {
        this.oracleId = oracleId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(String releasedAt) {
        this.releasedAt = releasedAt;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public boolean isBooster() {
        return booster;
    }

    public void setBooster(boolean booster) {
        this.booster = booster;
    }

    public String getIllustrationId() {
        return illustrationId;
    }

    public void setIllustrationId(String illustrationId) {
        this.illustrationId = illustrationId;
    }

    public boolean isPromo() {
        return promo;
    }

    public void setPromo(boolean promo) {
        this.promo = promo;
    }

    public List<String> getArtistIds() {
        return artistIds;
    }

    public void setArtistIds(List<String> artistIds) {
        this.artistIds = artistIds;
    }

    public int getMtgoId() {
        return mtgoId;
    }

    public void setMtgoId(int mtgoId) {
        this.mtgoId = mtgoId;
    }

    public String getRulingsUri() {
        return rulingsUri;
    }

    public void setRulingsUri(String rulingsUri) {
        this.rulingsUri = rulingsUri;
    }

    public String getCollectorNumber() {
        return collectorNumber;
    }

    public void setCollectorNumber(String collectorNumber) {
        this.collectorNumber = collectorNumber;
    }

    public List<String> getFinishes() {
        return finishes;
    }

    public void setFinishes(List<String> finishes) {
        this.finishes = finishes;
    }

    public String getSetUri() {
        return setUri;
    }

    public void setSetUri(String setUri) {
        this.setUri = setUri;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Prices getPrices() {
        return prices;
    }

    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public boolean isHighresImage() {
        return highresImage;
    }

    public void setHighresImage(boolean highresImage) {
        this.highresImage = highresImage;
    }

    public boolean isDigital() {
        return digital;
    }

    public void setDigital(boolean digital) {
        this.digital = digital;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public boolean isReprint() {
        return reprint;
    }

    public void setReprint(boolean reprint) {
        this.reprint = reprint;
    }

    public boolean isFullArt() {
        return fullArt;
    }

    public void setFullArt(boolean fullArt) {
        this.fullArt = fullArt;
    }

    public ImageUris getImage_uris() {
        return image_uris;
    }

    public void setImage_uris(ImageUris image_uris) {
        this.image_uris = image_uris;
    }

    public boolean isNonfoil() {
        return nonfoil;
    }

    public void setNonfoil(boolean nonfoil) {
        this.nonfoil = nonfoil;
    }

    public String getCardBackId() {
        return cardBackId;
    }

    public void setCardBackId(String cardBackId) {
        this.cardBackId = cardBackId;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public List<Integer> getMultiverseIds() {
        return multiverseIds;
    }

    public void setMultiverseIds(List<Integer> multiverseIds) {
        this.multiverseIds = multiverseIds;
    }

    public boolean isOversized() {
        return oversized;
    }

    public void setOversized(boolean oversized) {
        this.oversized = oversized;
    }

    public boolean isStorySpotlight() {
        return storySpotlight;
    }

    public void setStorySpotlight(boolean storySpotlight) {
        this.storySpotlight = storySpotlight;
    }

    public String getImageStatus() {
        return imageStatus;
    }

    public void setImageStatus(String imageStatus) {
        this.imageStatus = imageStatus;
    }

    public boolean isTextless() {
        return textless;
    }

    public void setTextless(boolean textless) {
        this.textless = textless;
    }

    public int getArenaId() {
        return arenaId;
    }

    public void setArenaId(int arenaId) {
        this.arenaId = arenaId;
    }

    public List<String> getFrameEffects() {
        return frameEffects;
    }

    public void setFrameEffects(List<String> frameEffects) {
        this.frameEffects = frameEffects;
    }

    public int getPennyRank() {
        return pennyRank;
    }

    public void setPennyRank(int pennyRank) {
        this.pennyRank = pennyRank;
    }

    public Preview getPreview() {
        return preview;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public String getSecurityStamp() {
        return securityStamp;
    }

    public void setSecurityStamp(String securityStamp) {
        this.securityStamp = securityStamp;
    }

    public List<String> getPromoTypes() {
        return promoTypes;
    }

    public void setPromoTypes(List<String> promoTypes) {
        this.promoTypes = promoTypes;
    }

    public List<AllPartsItem> getAllParts() {
        return allParts;
    }

    public void setAllParts(List<AllPartsItem> allParts) {
        this.allParts = allParts;
    }

    public List<CardFacesItem> getCardFaces() {
        return cardFaces;
    }

    public void setCardFaces(List<CardFacesItem> cardFaces) {
        this.cardFaces = cardFaces;
    }

    public List<String> getProducedMana() {
        return producedMana;
    }

    public void setProducedMana(List<String> producedMana) {
        this.producedMana = producedMana;
    }

    public List<String> getColorIndicator() {
        return colorIndicator;
    }

    public void setColorIndicator(List<String> colorIndicator) {
        this.colorIndicator = colorIndicator;
    }

    public String getPrinted_name() {
        return printed_name;
    }

    public void setPrinted_name(String printed_name) {
        this.printed_name = printed_name;
    }
}
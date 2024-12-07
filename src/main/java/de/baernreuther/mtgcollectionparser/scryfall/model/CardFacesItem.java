package de.baernreuther.mtgcollectionparser.scryfall.model;

import java.util.List;

public class CardFacesItem{
	private String oracleText;
	private String artist;
	private String typeLine;
	private List<String> colorIndicator;
	private ImageUris imageUris;
	private String artistId;
	private List<String> colors;
	private String flavorText;
	private String illustrationId;
	private String manaCost;
	private String name;
	private String power;
	private String toughness;
	private String object;
	private String defense;

	public String getOracleText(){
		return oracleText;
	}

	public String getArtist(){
		return artist;
	}

	public String getTypeLine(){
		return typeLine;
	}

	public List<String> getColorIndicator(){
		return colorIndicator;
	}

	public ImageUris getImageUris(){
		return imageUris;
	}

	public String getArtistId(){
		return artistId;
	}

	public List<String> getColors(){
		return colors;
	}

	public String getFlavorText(){
		return flavorText;
	}

	public String getIllustrationId(){
		return illustrationId;
	}

	public String getManaCost(){
		return manaCost;
	}

	public String getName(){
		return name;
	}

	public String getPower(){
		return power;
	}

	public String getToughness(){
		return toughness;
	}

	public String getObject(){
		return object;
	}

	public String getDefense(){
		return defense;
	}
}
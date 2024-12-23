package de.baernreuther.mtgcollectionparser.scryfall.model.bulk;

public class DataItem{
	private String contentType;
	private String download_uri;
	private String contentEncoding;
	private String name;
	private String description;
	private String id;
	private String type;
	private String uri;
	private String object;


	public void setContentType(String contentType){
		this.contentType = contentType;
	}

	public String getContentType(){
		return contentType;
	}

	public void setDownload_uri(String download_uri){
		this.download_uri = download_uri;
	}

	public String getDownload_uri(){
		return download_uri;
	}

	public void setContentEncoding(String contentEncoding){
		this.contentEncoding = contentEncoding;
	}

	public String getContentEncoding(){
		return contentEncoding;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUri(String uri){
		this.uri = uri;
	}

	public String getUri(){
		return uri;
	}

	public void setObject(String object){
		this.object = object;
	}

	public String getObject(){
		return object;
	}
}

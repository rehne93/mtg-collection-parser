package de.baernreuther.mtgcollectionparser.scryfall.model.bulk;

import java.util.List;

public class BulkInfoResponse{
	private List<DataItem> data;
	private boolean hasMore;
	private String object;

	public void setData(List<DataItem> data){
		this.data = data;
	}

	public List<DataItem> getData(){
		return data;
	}

	public void setHasMore(boolean hasMore){
		this.hasMore = hasMore;
	}

	public boolean isHasMore(){
		return hasMore;
	}

	public void setObject(String object){
		this.object = object;
	}

	public String getObject(){
		return object;
	}
}
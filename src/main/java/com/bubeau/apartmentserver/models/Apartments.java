package com.bubeau.apartmentserver.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "apartments")
public class Apartments {
	
	@Id
	private ObjectId _id;
	
	private String name;
	private Boolean active;
    private List<String> flats;
    
	public String get_id() {
		return _id.toHexString();
	}
	public String getName() {
		return name;
	}
	public Boolean getActive() {
		return active;
	}
	public List<String> getFlats() {
		return flats;
	}
    
    

}

package com.bubeau.apartmentserver.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Categories {

	@Id
	private ObjectId _id;
	private ObjectId apartmentId;
	private List<String> category;

	public String get_id() {
		return _id.toHexString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getApartmentId() {
		return apartmentId.toHexString();
	}

	public void setApartmentId(ObjectId apartmentId) {
		this.apartmentId = apartmentId;
	}

	public List<String> getCategory() {
		return category;
	}

	public void setCategory(List<String> category) {
		this.category = category;
	}

}

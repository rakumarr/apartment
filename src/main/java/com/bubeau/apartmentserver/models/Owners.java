package com.bubeau.apartmentserver.models;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Owners {

	@Id
	private ObjectId _id;
	private ObjectId apartmentId;
	private String flat;
	private String name;
	private String contact;
	private List<String> userIds;
	private boolean resident;
		
	public Owners() {
		super();
	}
	
	public Owners(ObjectId _id, ObjectId apartmentId, String flat, String name) {
		super();
		this._id = _id;
		this.apartmentId = apartmentId;
		this.flat = flat;
		this.name = name;
	}

	public String get_id() {
		return _id.toHexString();
	}
	
	public String getApartmentId() {
		return apartmentId.toHexString();
	}

	public String getFlat() {
		return flat;
	}

	public String getName() {
		return name;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public void setApartmentId(ObjectId apartmentId) {
		this.apartmentId = apartmentId;
	}

	public void setFlat(String flat) {
		this.flat = flat;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isResident() {
		return resident;
	}

	public void setResident(boolean resident) {
		this.resident = resident;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}

}

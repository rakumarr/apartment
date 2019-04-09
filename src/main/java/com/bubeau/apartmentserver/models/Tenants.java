package com.bubeau.apartmentserver.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Tenants {
	
	@Id
	private ObjectId _id;
	private ObjectId apartmentId;
	private ObjectId ownerId;
	private String flat;
	private String name;
	private String contact;
	private boolean active;
	private Date startDate;
	private Date endDate;
	
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
	public String getOwnerId() {
		return ownerId.toHexString();
	}
	public void setOwnerId(ObjectId ownerId) {
		this.ownerId = ownerId;
	}
	public String getFlat() {
		return flat;
	}
	public void setFlat(String flat) {
		this.flat = flat;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
	

}

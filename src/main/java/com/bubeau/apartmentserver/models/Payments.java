package com.bubeau.apartmentserver.models;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class Payments {
	
	@Id
	private ObjectId _id;
	private ObjectId apartmentId;
	private Date paymentDate;
	private String category;
	private int amount;
	private String notes;
	private String createdBy;
	
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
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}

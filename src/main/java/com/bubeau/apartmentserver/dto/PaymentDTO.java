package com.bubeau.apartmentserver.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class PaymentDTO {

	@NotNull
	private Date paymentDate;
	@NotNull
	private String category;
	@NotNull
	private int amount;
	private String notes;
	@NotNull
	private String createdBy;
	
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

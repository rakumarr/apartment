package com.bubeau.apartmentserver.dto;

import com.bubeau.apartmentserver.models.Authorization;

public class UserDTO {
	
	private String apartmentId;
	private String apartmentName;
	private Authorization authorization;
	public String getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(String apartmentId) {
		this.apartmentId = apartmentId;
	}
	public String getApartmentName() {
		return apartmentName;
	}
	public void setApartmentName(String apartmentName) {
		this.apartmentName = apartmentName;
	}
	public Authorization getAuthorization() {
		return authorization;
	}
	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

}

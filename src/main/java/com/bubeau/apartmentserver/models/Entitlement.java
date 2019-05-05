package com.bubeau.apartmentserver.models;

import java.util.List;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "entitlement")
public class Entitlement {

	@Id
	private ObjectId _id;
	private ObjectId apartmentId;
	private List<Authorization> authorization;
	private List<String> users;
	private Map<String,List<String>> specialActions;
	
	public ObjectId get_id() {
		return _id;
	}
	public void set_id(ObjectId _id) {
		this._id = _id;
	}
	public ObjectId getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(ObjectId apartmentId) {
		this.apartmentId = apartmentId;
	}
	public List<Authorization> getAuthorization() {
		return authorization;
	}
	public void setAuthorization(List<Authorization> authorization) {
		this.authorization = authorization;
	}
	public List<String> getUsers() {
		return users;
	}
	public void setUsers(List<String> users) {
		this.users = users;
	}
	public Map<String,List<String>> getSpecialActions() {
		return specialActions;
	}
	public void setSpecialActions(Map<String,List<String>> specialActions) {
		this.specialActions = specialActions;
	}
			
}

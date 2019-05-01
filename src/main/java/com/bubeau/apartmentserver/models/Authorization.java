package com.bubeau.apartmentserver.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

public class Authorization {
	
	private String group;
	private List<String> allowedActions;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private List<String> users;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<String> getAllowedActions() {
		return allowedActions;
	}
	public void setAllowedActions(List<String> allowedActions) {
		this.allowedActions = allowedActions;
	}
	public List<String> getUsers() {
		return users;
	}
	public void setUsers(List<String> users) {
		this.users = users;
	}
	
}

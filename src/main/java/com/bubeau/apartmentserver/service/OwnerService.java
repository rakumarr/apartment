package com.bubeau.apartmentserver.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.bubeau.apartmentserver.dto.OwnersDTO;
import com.bubeau.apartmentserver.models.Owners;

public interface OwnerService {

	void saveOwner(ObjectId id, OwnersDTO owners);
	
	List<Owners> viewOwners(ObjectId id);

	List<Owners> getAssests(ObjectId id, String token);

}
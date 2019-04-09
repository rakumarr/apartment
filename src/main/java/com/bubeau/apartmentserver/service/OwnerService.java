package com.bubeau.apartmentserver.service;

import org.bson.types.ObjectId;

import com.bubeau.apartmentserver.dto.OwnersDTO;

public interface OwnerService {

	void saveOwner(ObjectId id, OwnersDTO owners);

}
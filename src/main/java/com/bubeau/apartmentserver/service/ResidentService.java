package com.bubeau.apartmentserver.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.bubeau.apartmentserver.dto.ResidentDTO;

public interface ResidentService {

	public List<ResidentDTO> getResidents(ObjectId id);

}

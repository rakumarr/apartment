package com.bubeau.apartmentserver.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bubeau.apartmentserver.dto.ResidentDTO;
import com.bubeau.apartmentserver.service.ResidentService;

@RestController
@RequestMapping("/api/residents")
public class ResidentController {
	
	@Autowired
	ResidentService residentService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<ResidentDTO> getResidents(@PathVariable ObjectId id) {
		return residentService.getResidents(id);
	}

}

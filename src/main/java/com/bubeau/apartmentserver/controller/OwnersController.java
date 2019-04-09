package com.bubeau.apartmentserver.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bubeau.apartmentserver.dto.OwnersDTO;
import com.bubeau.apartmentserver.models.Owners;
import com.bubeau.apartmentserver.repository.OwnersRepository;
import com.bubeau.apartmentserver.service.OwnerService;

@RestController
@RequestMapping("/api/owners")
public class OwnersController {
	
	@Autowired private OwnersRepository repository;
	@Autowired private OwnerService ownersService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Owners> getAllPets() {
	  return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void modifyOwnerById(@PathVariable ObjectId id, @Valid @RequestBody OwnersDTO owners) {
		ownersService.saveOwner(id, owners);
	}

}

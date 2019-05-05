package com.bubeau.apartmentserver.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.bubeau.apartmentserver.service.OwnerService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;

@RestController
@RequestMapping("/api/owners")
public class OwnersController {
	
	@Autowired private OwnerService ownersService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<Owners> getAllOwnersById(@PathVariable ObjectId id) {
	  return ownersService.viewOwners(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public void modifyOwnerById(@PathVariable ObjectId id, @Valid @RequestBody OwnersDTO owners) {
		ownersService.saveOwner(id, owners);
	}

	@RequestMapping(value = "/asset/{id}", method = RequestMethod.GET)
	public List<Owners> getUserOwnedAssestById(HttpServletRequest request,
			@PathVariable ObjectId id) {
		Payload payload = (Payload) request.getAttribute("user");
		return ownersService.getAssests(id, payload.getEmail());
	}

}

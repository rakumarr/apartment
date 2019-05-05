package com.bubeau.apartmentserver.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bubeau.apartmentserver.dto.UserDTO;
import com.bubeau.apartmentserver.service.EntitlementService;
import com.bubeau.apartmentserver.service.UserDetailsService;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private EntitlementService entitlementService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<UserDTO> getUserEntitlement(HttpServletRequest request) throws GeneralSecurityException, IOException {
		Payload payload = (Payload) request.getAttribute("user");		
		return entitlementService.getUserEntitlement(payload.getEmail());
	}

}

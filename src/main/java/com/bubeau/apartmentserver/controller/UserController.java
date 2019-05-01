package com.bubeau.apartmentserver.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

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
	private UserDetailsService userDetailsService;
	
	@Autowired
	private EntitlementService entitlementService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public List<UserDTO> getUserEntitlement(@RequestBody String token) throws GeneralSecurityException, IOException {
		System.out.println(token);
		Payload payload = userDetailsService.getUser(token);
		if(payload != null) {
			payload.getEmail();
		}
		return entitlementService.getUserEntitlement(payload.getEmail());
	}

}

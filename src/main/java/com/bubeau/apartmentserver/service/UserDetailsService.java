package com.bubeau.apartmentserver.service;

import java.io.IOException;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import java.security.GeneralSecurityException;

import com.bubeau.apartmentserver.models.User;

public interface UserDetailsService {
	
	public User findUserByEmail(String email);

	public Payload getUser(String token) throws GeneralSecurityException, IOException;

}

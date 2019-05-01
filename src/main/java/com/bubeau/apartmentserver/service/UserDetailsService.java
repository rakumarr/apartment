package com.bubeau.apartmentserver.service;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.bubeau.apartmentserver.models.User;

public interface UserDetailsService {
	
	public User findUserByEmail(String email);

	public void getUser(String token) throws GeneralSecurityException, IOException;

}

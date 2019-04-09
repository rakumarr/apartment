package com.bubeau.apartmentserver.service;

import com.bubeau.apartmentserver.models.User;

public interface UserDetailsService {
	
	public User findUserByEmail(String email);

}

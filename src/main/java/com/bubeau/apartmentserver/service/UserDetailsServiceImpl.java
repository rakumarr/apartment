package com.bubeau.apartmentserver.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.bubeau.apartmentserver.models.User;
import com.bubeau.apartmentserver.repository.RoleRepository;
import com.bubeau.apartmentserver.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}

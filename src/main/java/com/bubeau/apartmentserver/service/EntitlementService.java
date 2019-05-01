package com.bubeau.apartmentserver.service;

import java.util.List;

import com.bubeau.apartmentserver.dto.UserDTO;

public interface EntitlementService {
	
	public List<UserDTO> getUserEntitlement(String user);

}

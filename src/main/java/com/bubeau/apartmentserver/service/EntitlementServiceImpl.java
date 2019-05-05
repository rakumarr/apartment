package com.bubeau.apartmentserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubeau.apartmentserver.dto.UserDTO;
import com.bubeau.apartmentserver.models.Apartments;
import com.bubeau.apartmentserver.models.Authorization;
import com.bubeau.apartmentserver.models.Entitlement;
import com.bubeau.apartmentserver.repository.ApartmentsRepository;
import com.bubeau.apartmentserver.repository.EntitlementRepository;

@Service
public class EntitlementServiceImpl implements EntitlementService {
	
	@Autowired
	EntitlementRepository entitlementRepository;
	
	@Autowired
	private ApartmentsRepository apartmentsRepository;

	@Override
	public List<UserDTO> getUserEntitlement(String user) {
		System.out.println(entitlementRepository.findAll());
		//Filter and get only those present in Users List
		List<Entitlement> entitlements = entitlementRepository.findAll().stream()
				.filter(entitlement -> entitlement.getUsers().contains(user)).collect(Collectors.toList());
		List<UserDTO> userDTOs = new ArrayList<>(entitlements.size());
		
		//Get all Active Apartments
		Map<String, String> apt = apartmentsRepository.findAll().stream()
				.collect(Collectors.toMap(Apartments::get_id, Apartments::getName));
		
		//Iterate over Entitlement and create User Entitlement
		entitlements.forEach(ent -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setApartmentId(ent.getApartmentId().toHexString());
			userDTO.setApartmentName(apt.get(ent.getApartmentId().toHexString()));
			Optional<Authorization> auth = ent.getAuthorization().stream()
					.filter(author -> author.getUsers().contains(user)).findFirst();
			if (auth.isPresent()) {
				Authorization authorization = auth.get();
				Set<String> specialActions = ent.getSpecialActions().keySet();
				//Set allowed actions
				authorization.setAllowedActions(authorization.getAllowedActions().stream().filter(
						action -> !specialActions.contains(action) || ent.getSpecialActions().containsKey(user))
						.collect(Collectors.toList()));
				userDTO.setAuthorization(authorization);
				userDTOs.add(userDTO);
			}
		});

		return userDTOs;
	}

}

package com.bubeau.apartmentserver.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
		List<Entitlement> entitlements = entitlementRepository.findAll().stream()
				.filter(entitlement -> entitlement.getUsers().contains(user)).collect(Collectors.toList());
		List<UserDTO> userDTOs = new ArrayList<>(entitlements.size());
		Map<String, String> apt = apartmentsRepository.findAll().stream()
				.collect(Collectors.toMap(Apartments::get_id, Apartments::getName));
		entitlements.forEach(ent -> {
			UserDTO userDTO = new UserDTO();
			userDTO.setApartmentId(ent.getApartmentId().toHexString());
			userDTO.setApartmentName(apt.get(ent.getApartmentId().toHexString()));
			Optional<Authorization> auth = ent.getAuthorization().stream()
					.filter(author -> author.getUsers().contains(user)).findFirst();
			if (auth.isPresent()) {
				userDTO.setAuthorization(auth.get());
				userDTOs.add(userDTO);
			}
		});

		return userDTOs;
	}

}

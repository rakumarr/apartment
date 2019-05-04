package com.bubeau.apartmentserver.service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubeau.apartmentserver.dto.ResidentDTO;
import com.bubeau.apartmentserver.models.Owners;
import com.bubeau.apartmentserver.models.Tenants;
import com.bubeau.apartmentserver.repository.OwnersRepository;
import com.bubeau.apartmentserver.repository.TenantsRepository;

@Service
public class ResidentServiceImpl implements ResidentService {

	Function<Owners, ResidentDTO> ownersTransferToResident = new Function<Owners, ResidentDTO>() {

		@Override
		public ResidentDTO apply(Owners t) {
			ResidentDTO dto = new ResidentDTO();
			dto.setApartmentId(t.getApartmentId());
			// dto.setContact();
			dto.setFlat(t.getFlat());
			dto.setName(t.getName());
			dto.setContact(t.getContact());
			dto.setOwner(true);
			return dto;
		}

	};

	Function<Tenants, ResidentDTO> tenantsTransferToResident = new Function<Tenants, ResidentDTO>() {

		@Override
		public ResidentDTO apply(Tenants t) {
			ResidentDTO dto = new ResidentDTO();
			dto.setApartmentId(t.getApartmentId());
			dto.setContact(t.getContact());
			dto.setFlat(t.getFlat());
			dto.setName(t.getName());
			dto.setOwner(false);
			return dto;
		}

	};

	@Autowired
	private OwnersRepository ownersRepository;

	@Autowired
	private TenantsRepository tenantsRepository;

	@Override
	public List<ResidentDTO> getResidents(ObjectId id) {

		Predicate<Owners> aptCheck = owner -> owner.getApartmentId().equals(id.toHexString());
		Predicate<Owners> isResidentCheck = owner -> owner.isResident();

		List<ResidentDTO> residents = ownersRepository.findAll().stream().filter(aptCheck.and(isResidentCheck))
				.map(ownersTransferToResident).collect(Collectors.toList());

		Predicate<Tenants> isTenantActive = tenant -> tenant.isActive();

		residents.addAll(tenantsRepository.findAll().stream().filter(isTenantActive).map(tenantsTransferToResident)
				.collect(Collectors.toList()));

		return residents;
	}

}

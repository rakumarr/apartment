package com.bubeau.apartmentserver.service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubeau.apartmentserver.dto.TenantDTO;
import com.bubeau.apartmentserver.models.Tenants;
import com.bubeau.apartmentserver.repository.TenantsRepository;

@Service
public class TenantsServiceImpl implements TenantsService {

	Function<Tenants, TenantDTO> transfer = new Function<Tenants, TenantDTO>() {

		@Override
		public TenantDTO apply(Tenants t) {
			TenantDTO tenantDTO = new TenantDTO();
			tenantDTO.setApartmentId(t.getApartmentId());
			tenantDTO.setContact(t.getContact());
			tenantDTO.setEndDate(t.getEndDate());
			tenantDTO.setFlat(t.getFlat());
			tenantDTO.setName(t.getName());
			tenantDTO.setOwnerId(t.getOwnerId());
			tenantDTO.setStartDate(t.getStartDate());
			tenantDTO.setActive(t.isActive());
			return tenantDTO;
		}
	};

	@Autowired
	TenantsRepository tenantsRepository;

	@Override
	public void addTenant(TenantDTO tenantDto) {
		Tenants tenants = new Tenants();
		tenants.setActive(true);
		tenants.setApartmentId(new ObjectId(tenantDto.getApartmentId()));
		tenants.setContact(tenantDto.getContact());
		tenants.setFlat(tenantDto.getFlat());
		tenants.setName(tenantDto.getName());
		tenants.setOwnerId(new ObjectId(tenantDto.getOwnerId()));
		tenants.setStartDate(tenantDto.getStartDate());
		tenantsRepository.save(tenants);
	}

	@Override
	public void deleteTenant(ObjectId id) {
		throw new RuntimeException("Not Available Yet");
	}

	@Override
	public List<TenantDTO> getAllTenants(ObjectId id) {
		Predicate<Tenants> aptCheck = apt -> apt.getApartmentId().equals(id.toHexString());

		return tenantsRepository.findAll().stream().filter(aptCheck).map(transfer)
				.collect(Collectors.toList());
	}

}

package com.bubeau.apartmentserver.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.bubeau.apartmentserver.dto.TenantDTO;

public interface TenantsService {
	
	public void addTenant(TenantDTO tenantDto);
	
	public void deleteTenant(ObjectId id);

	public List<TenantDTO> getAllTenants(ObjectId id);

}

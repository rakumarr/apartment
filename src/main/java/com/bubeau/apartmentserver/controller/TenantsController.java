package com.bubeau.apartmentserver.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bubeau.apartmentserver.dto.TenantDTO;
import com.bubeau.apartmentserver.service.TenantsService;

@RestController
@RequestMapping("/api/tenants")
public class TenantsController {

	@Autowired
	TenantsService tenantsService;

	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public void addTenant(@PathVariable ObjectId id,  @Valid @RequestBody TenantDTO tenantDto) {
		tenantsService.addTenant(tenantDto);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
	public void deleteTenant(@PathVariable ObjectId id) {
		tenantsService.deleteTenant(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public List<TenantDTO> getTenants(@PathVariable ObjectId id) {
		return tenantsService.getAllTenants(id);
	}

}

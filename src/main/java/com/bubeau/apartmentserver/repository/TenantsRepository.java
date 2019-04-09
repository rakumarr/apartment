package com.bubeau.apartmentserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bubeau.apartmentserver.models.Tenants;

public interface TenantsRepository extends MongoRepository<Tenants, String> {
	
}

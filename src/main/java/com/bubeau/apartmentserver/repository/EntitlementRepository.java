package com.bubeau.apartmentserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bubeau.apartmentserver.models.Entitlement;

public interface EntitlementRepository extends MongoRepository<Entitlement, String>{

}

package com.bubeau.apartmentserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bubeau.apartmentserver.models.Role;

public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}
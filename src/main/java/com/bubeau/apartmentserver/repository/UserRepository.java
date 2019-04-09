package com.bubeau.apartmentserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bubeau.apartmentserver.models.User;

public interface UserRepository extends MongoRepository<User, String> {

    User findByEmail(String email);

}
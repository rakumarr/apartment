package com.bubeau.apartmentserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bubeau.apartmentserver.models.Apartments;

public interface ApartmentsRepository extends MongoRepository<Apartments, String> {

}

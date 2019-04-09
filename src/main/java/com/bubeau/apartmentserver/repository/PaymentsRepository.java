package com.bubeau.apartmentserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bubeau.apartmentserver.models.Payments;

public interface PaymentsRepository extends MongoRepository<Payments, String> {

}

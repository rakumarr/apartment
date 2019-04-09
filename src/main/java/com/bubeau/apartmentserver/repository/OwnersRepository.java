package com.bubeau.apartmentserver.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.bubeau.apartmentserver.models.Owners;

public interface OwnersRepository extends MongoRepository<Owners, String> {

}

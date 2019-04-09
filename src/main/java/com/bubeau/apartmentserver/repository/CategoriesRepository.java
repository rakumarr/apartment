package com.bubeau.apartmentserver.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.bubeau.apartmentserver.models.Categories;

public interface CategoriesRepository extends MongoRepository<Categories, String> {
	
	Categories findBy_id(ObjectId _id);

}

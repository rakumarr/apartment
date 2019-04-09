package com.bubeau.apartmentserver.service;

import org.bson.types.ObjectId;

public interface CategoriesService {
	
	void add(ObjectId id, String category);

}

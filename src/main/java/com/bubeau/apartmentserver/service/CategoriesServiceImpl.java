package com.bubeau.apartmentserver.service;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubeau.apartmentserver.models.Categories;
import com.bubeau.apartmentserver.repository.CategoriesRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	CategoriesRepository categoriesRepository;

	@Override
	public void add(ObjectId id, String category) {
		// TODO Auto-generated method stub
		Optional<Categories> categories = categoriesRepository.findAll().stream()
				.filter(apt -> apt.getApartmentId().equals(id.toString())).findFirst();
		if(categories.isPresent()) {
			Categories categoryObj = categories.get();
			if(!categoryObj.getCategory().contains(category)) {
				categoryObj.getCategory().add(category);
				categoriesRepository.save(categoryObj);
			}
		} else {
			throw new RuntimeException("Apartment Category not configured");
		}
	}

}

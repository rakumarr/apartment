package com.bubeau.apartmentserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bubeau.apartmentserver.models.Categories;
import com.bubeau.apartmentserver.repository.CategoriesRepository;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {
	
@Autowired private CategoriesRepository repository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Categories> getAllCategories() {
	  return repository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Categories getCategoriesById(@RequestParam ("id") String id) {
	  return repository.findById(id).get();
	}

}

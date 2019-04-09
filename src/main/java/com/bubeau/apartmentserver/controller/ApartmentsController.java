package com.bubeau.apartmentserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bubeau.apartmentserver.models.Apartments;
import com.bubeau.apartmentserver.repository.ApartmentsRepository;

@RestController
@RequestMapping("/api/apartments")
public class ApartmentsController {

	@Autowired
	private ApartmentsRepository apartmentsRepository;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Apartments> getAllApartments() {
		return apartmentsRepository.findAll();
	}

}

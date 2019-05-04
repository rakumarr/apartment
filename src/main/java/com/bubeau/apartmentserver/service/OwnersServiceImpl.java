package com.bubeau.apartmentserver.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bubeau.apartmentserver.dto.OwnersDTO;
import com.bubeau.apartmentserver.models.Apartments;
import com.bubeau.apartmentserver.models.Owners;
import com.bubeau.apartmentserver.repository.ApartmentsRepository;
import com.bubeau.apartmentserver.repository.OwnersRepository;

@Service
public class OwnersServiceImpl implements OwnerService {

	@Autowired
	private OwnersRepository repository;
	
	@Autowired
	private ApartmentsRepository apartmentsRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.bubeau.apartmentserver.service.OwnerServiceInterface#saveOwner(org.bson.
	 * types.ObjectId, com.bubeau.apartmentserver.dto.OwnersDTO)
	 */
	@Override
	public void saveOwner(ObjectId id, OwnersDTO owners) {
		Optional<Apartments> apartment = apartmentsRepository.findAll().stream()
				.filter(apt -> apt.get_id().toString().equals(id.toString())).findFirst();
		if (apartment.isPresent()) {
			if (!apartment.get().getFlats().contains(owners.getFlat())) {
				throw new RuntimeException("Flat not available");
			}
			Owners owner = null;
			Optional<Owners> optionalOwner = repository.findAll().stream()
					.filter(ownerObj -> id.toString().equals(ownerObj.getApartmentId())
							&& owners.getFlat().equals(ownerObj.getFlat()))
					.findFirst();
			if (optionalOwner.isPresent()) {
				owner = optionalOwner.get();
				owner.setName(owners.getName());
			} else {
				owner = new Owners();
			}
			owner.setApartmentId(id);
			owner.setFlat(owners.getFlat());
			owner.setName(owners.getName());
			repository.save(owner);

		} else {
			throw new RuntimeException("Apartment not allowed");
		}
	}

	@Override
	public List<Owners> viewOwners(ObjectId id) {
		return repository.findAll().stream().filter(apt -> apt.get_id().toString().equals(id.toString()))
				.collect(Collectors.toList());
	}

}

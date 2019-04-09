package com.bubeau.apartmentserver.service;

import java.util.List;
import java.util.stream.Collectors;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bubeau.apartmentserver.dto.PaymentDTO;
import com.bubeau.apartmentserver.models.Payments;
import com.bubeau.apartmentserver.repository.PaymentsRepository;

@Service
public class PaymentsServiceImpl implements PaymentsService{
	
	@Autowired PaymentsRepository paymentsRepository;
	@Autowired CategoriesService categoriesService;

	@Override
	@Transactional
	public void addPayment(ObjectId id, PaymentDTO payment) {
		Payments payments = new Payments();
		payments.setApartmentId(id);
		payments.setAmount(payment.getAmount());
		payments.setCategory(payment.getCategory());
		payments.setCreatedBy(payment.getCreatedBy());
		payments.setPaymentDate(payment.getPaymentDate());
		payments.setNotes(payment.getNotes());
		paymentsRepository.save(payments);
		//Save the Category
		categoriesService.add(id, payment.getCategory());
	}

	@Override
	public List<Payments> getPayments(ObjectId aptId) {
		return paymentsRepository.findAll().stream().filter(apt -> apt.getApartmentId().equals(aptId.toString())).collect(Collectors.toList());		
	}

}

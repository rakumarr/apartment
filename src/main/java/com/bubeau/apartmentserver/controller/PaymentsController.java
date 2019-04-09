package com.bubeau.apartmentserver.controller;

import java.util.List;

import javax.validation.Valid;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bubeau.apartmentserver.dto.PaymentDTO;
import com.bubeau.apartmentserver.models.Payments;
import com.bubeau.apartmentserver.service.PaymentsService;

@RestController
@RequestMapping("/api/payments")
public class PaymentsController {
	
	@Autowired PaymentsService paymentsService;
	
	@RequestMapping(value = "/{aptId}", method = RequestMethod.GET)
	public List<Payments> getPayments(@PathVariable ObjectId aptId) {
		return paymentsService.getPayments(aptId);
	}
			
	@RequestMapping(value = "/{aptId}", method = RequestMethod.POST)
	public void addPayment(@PathVariable ObjectId aptId, @Valid @RequestBody PaymentDTO payment) {
		paymentsService.addPayment(aptId, payment);
	}
	
	

}

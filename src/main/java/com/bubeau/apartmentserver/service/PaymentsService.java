package com.bubeau.apartmentserver.service;

import java.util.List;

import org.bson.types.ObjectId;

import com.bubeau.apartmentserver.dto.PaymentDTO;
import com.bubeau.apartmentserver.models.Payments;


public interface PaymentsService {
	
	void addPayment(ObjectId id, PaymentDTO payment);

	List<Payments> getPayments(ObjectId aptId);

}

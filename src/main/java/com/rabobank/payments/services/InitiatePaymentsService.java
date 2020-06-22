package com.rabobank.payments.services;

import org.springframework.stereotype.Service;

import com.rabobank.payments.beans.requests.PaymentInitiationRequest;

@Service
public class InitiatePaymentsService {
	
	public boolean initiatePayments(PaymentInitiationRequest paymentInitiationRequest) {
		
		return true;
	}

}

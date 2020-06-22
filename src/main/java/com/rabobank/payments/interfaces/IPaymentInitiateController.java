package com.rabobank.payments.interfaces;

import org.springframework.http.ResponseEntity;

import com.rabobank.payments.beans.requests.PaymentInitiationRequest;

public abstract class IPaymentInitiateController implements InitiatePayment{
	
	public abstract ResponseEntity<?> initiatePayment(String xRequestId,
			String signatureCertificate,
			String signature,
			PaymentInitiationRequest paymentInitiationRequest);
	
	@Override
	public void initiatePayment() {
		// TODO Auto-generated method stub
		
	}
	

}

package com.rabobank.payments.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitiatePaymentsController {

	@PostMapping("/v1.0.0/initiate-payment")
	public String initiatePayments() {
		return "Payment initialted!";
	}
	
	
}

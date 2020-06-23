package com.rabobank.payments.utils;

import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class PaymentsUtils {
	
	public String generateUUID() {
		final String uuid = UUID.randomUUID().toString();
		return uuid;
	}	

}

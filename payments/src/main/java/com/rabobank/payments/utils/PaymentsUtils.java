package com.rabobank.payments.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabobank.payments.beans.responses.PaymentAcceptedResponse;

@Component
public class PaymentsUtils {
	
	@Autowired
	public TestBeansCreatorUtil beansUtil;
	
	public PaymentAcceptedResponse getPaymentAcceptedResponse() {
		
		return beansUtil.getPaymentAcceptedResponse();
	}
	

}

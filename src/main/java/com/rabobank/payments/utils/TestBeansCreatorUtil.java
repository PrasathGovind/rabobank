package com.rabobank.payments.utils;

import org.springframework.stereotype.Component;

import com.rabobank.payments.beans.enums.ErrorReasonCode;
import com.rabobank.payments.beans.enums.TransactionStatus;
import com.rabobank.payments.beans.responses.PaymentAcceptedResponse;
import com.rabobank.payments.beans.responses.PaymentRejectedResponse;

@Component
public class TestBeansCreatorUtil {
	
	PaymentAcceptedResponse paymentAcceptedResponse = new PaymentAcceptedResponse();
	
	PaymentRejectedResponse paymentRejectedResponse = new PaymentRejectedResponse();
	
	
	public PaymentAcceptedResponse getPaymentAcceptedResponse() {
		
		paymentAcceptedResponse.setPaymentId("aosdh87253asd12");
		paymentAcceptedResponse.setStatus(TransactionStatus.Accepted);
		return paymentAcceptedResponse;
	}
	
	public PaymentRejectedResponse getPaymentRejectedResponse() {
		
		paymentRejectedResponse.setReason("Sample message for testing PaymentRejectedResponse");
		paymentRejectedResponse.setReasonCode(ErrorReasonCode.GENERAL_ERROR);
		paymentRejectedResponse.setStatus(TransactionStatus.Rejected);
		return paymentRejectedResponse;
	}
	
	

}

package com.rabobank.payments.testbeans;

import com.rabobank.payments.beans.enums.ErrorReasonCode;
import com.rabobank.payments.beans.enums.TransactionStatus;
import com.rabobank.payments.beans.requests.PaymentInitiationRequest;
import com.rabobank.payments.beans.responses.PaymentAcceptedResponse;
import com.rabobank.payments.beans.responses.PaymentRejectedResponse;

public class TestBeansCreatorUtil {
	
	PaymentAcceptedResponse paymentAcceptedResponse = new PaymentAcceptedResponse();
	
	PaymentRejectedResponse paymentRejectedResponse = new PaymentRejectedResponse();
	
	PaymentInitiationRequest paymentInitiationRequest = new PaymentInitiationRequest();
	
	
	public PaymentInitiationRequest getPaymentInitiationRequest() {
		
		paymentInitiationRequest.setAmount("23.19");
		paymentInitiationRequest.setCurrency("USD");
		paymentInitiationRequest.setDebtorIBAN("NL02RABO7134384551");
		paymentInitiationRequest.setCreditorIBAN("NL94ABNA1008270121");
		paymentInitiationRequest.setEndToEndId("cecd7bc8-e706-49dd-91c2-67a537efb107");
		
		return paymentInitiationRequest;
	}
	
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

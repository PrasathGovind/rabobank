package com.rabobank.payments.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rabobank.payments.advices.exceptions.APIException;
import com.rabobank.payments.beans.enums.ErrorReasonCode;
import com.rabobank.payments.beans.requests.PaymentInitiationRequest;

@Component
public class InitiatePaymentsControllerRequestsValidator {
	
	@Autowired
	RabobankSignatureValidatorEngine rabobankSignatureValidatorEngine;
	
	public void validatePaymentInitiationRequest(String xRequestId, String signatureCertificate, 
													String signature, PaymentInitiationRequest paymentInitiationRequest) {
		
		// If the RequestId is missing, it is not coming from the right client
		if(xRequestId==null || paymentInitiationRequest==null) {
			throw new APIException(ErrorReasonCode.INVALID_REQUEST);
		}
		
		// If the Certificate is missing or the Signature is missing
		if(signatureCertificate==null || signature==null) {
			throw new APIException(ErrorReasonCode.GENERAL_ERROR);
		}
		
		// IBAN Validations for Creditor and Debtor
		if(paymentInitiationRequest.getDebtorIBAN()==null || paymentInitiationRequest.getDebtorIBAN().length() > 34 || paymentInitiationRequest.getDebtorIBAN().length() < 1
				|| paymentInitiationRequest.getCreditorIBAN()==null || paymentInitiationRequest.getCreditorIBAN().length() > 34 || paymentInitiationRequest.getCreditorIBAN().length() < 1) {
			throw new APIException(ErrorReasonCode.INVALID_REQUEST);
		}
		
		// Currency Code Validation
		if(paymentInitiationRequest.getCurrency()==null || paymentInitiationRequest.getCurrency().length()!=3) {
			throw new APIException(ErrorReasonCode.INVALID_REQUEST);
		}
		
		// Certificate Signature Validation
		rabobankSignatureValidatorEngine.setRequestId(xRequestId);
		rabobankSignatureValidatorEngine.setPublicKeyB64(signatureCertificate);
		rabobankSignatureValidatorEngine.setSignatureB64(signature);
		rabobankSignatureValidatorEngine.setPaymentInitiationRequest(paymentInitiationRequest);
		
		if(!rabobankSignatureValidatorEngine.isSignatureValid()) {
			throw new APIException(ErrorReasonCode.INVALID_SIGNATURE);
		}
		
	}

}

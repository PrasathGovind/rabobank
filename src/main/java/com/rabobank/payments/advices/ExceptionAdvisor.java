package com.rabobank.payments.advices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.rabobank.payments.advices.exceptions.APIException;
import com.rabobank.payments.beans.enums.TransactionStatus;
import com.rabobank.payments.beans.responses.PaymentRejectedResponse;
import com.rabobank.payments.utils.PaymentsUtils;

@RestControllerAdvice
@RequestMapping("/")
public class ExceptionAdvisor {
	
	@Autowired
	PaymentsUtils paymentsUtils;
	
	@ExceptionHandler(APIException.class)
	public ResponseEntity<PaymentRejectedResponse> handleAPIExceptions(APIException exception){
		
		PaymentRejectedResponse errorResponse = new PaymentRejectedResponse();
		errorResponse.setPaymentId(paymentsUtils.generateUUID());
		errorResponse.setReasonCode(exception.getErrorReasonCode());
		errorResponse.setReason(exception.getErrorReasonCode().getDescription());
		errorResponse.setStatus(TransactionStatus.Rejected);
		
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		if(exception.getErrorReasonCode().getStatusCode() == 400){
			status = HttpStatus.BAD_REQUEST;
		}else if(exception.getErrorReasonCode().getStatusCode() == 422){
			status = HttpStatus.UNPROCESSABLE_ENTITY;
		}else if(exception.getErrorReasonCode().getStatusCode() == 500){
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		
		return new ResponseEntity<PaymentRejectedResponse>(errorResponse, status);
	}

}

package com.rabobank.payments.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rabobank.payments.beans.requests.PaymentInitiationRequest;
import com.rabobank.payments.beans.responses.PaymentAcceptedResponse;
import com.rabobank.payments.interfaces.IPaymentInitiateController;
import com.rabobank.payments.services.InitiatePaymentsService;
import com.rabobank.payments.utils.PaymentsUtils;

@RestController
@RequestMapping("/v1.0.0")
public class InitiatePaymentsController extends IPaymentInitiateController {
	
	@Autowired
	PaymentsUtils paymentsUtil;
	
	@Autowired
	InitiatePaymentsService initiatePaymentsService;

	@PostMapping(value="/initiate-payment", consumes= {MediaType.APPLICATION_JSON_VALUE}, produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> initiatePayment(@RequestHeader("X-Request-Id") String xRequestId,
													@RequestHeader("Signature-Certificate") String signatureCertificate,
													@RequestHeader("Signature") String signature,
													@RequestBody PaymentInitiationRequest paymentInitiationRequest) {
		PaymentAcceptedResponse response = paymentsUtil.getPaymentAcceptedResponse();
		return new ResponseEntity<PaymentAcceptedResponse>(response, HttpStatus.OK);
	}
	
}

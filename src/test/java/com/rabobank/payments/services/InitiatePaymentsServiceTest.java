package com.rabobank.payments.services;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.rabobank.payments.beans.enums.TransactionStatus;
import com.rabobank.payments.beans.requests.PaymentInitiationRequest;
import com.rabobank.payments.beans.responses.PaymentAcceptedResponse;
import com.rabobank.payments.beans.responses.PaymentRejectedResponse;
import com.rabobank.payments.testbeans.TestBeansCreatorUtil;
import com.rabobank.payments.utils.PaymentsUtils;

@RunWith(MockitoJUnitRunner.class)
public class InitiatePaymentsServiceTest {
	
	@InjectMocks
	InitiatePaymentsService initiatePaymentsService;
	
	@Mock
	PaymentsUtils paymentsUtils;
	
	TestBeansCreatorUtil testBeansCreatorUtil = new TestBeansCreatorUtil();
	
	@Test
	public void testInitiatePaymentsSuccess() {
		
		PaymentInitiationRequest paymentInitiationRequest = testBeansCreatorUtil.getPaymentInitiationRequest();
		
		PaymentAcceptedResponse response = (PaymentAcceptedResponse) initiatePaymentsService.initiatePayments(paymentInitiationRequest);
		//System.out.println(response);
		assertTrue(response!=null && TransactionStatus.Accepted.equals(response.getStatus()));
	}
	
	@Test
	public void testInitiatePaymentsFailure() {
		
		PaymentInitiationRequest paymentInitiationRequest = testBeansCreatorUtil.getPaymentInitiationRequest();
		paymentInitiationRequest.setDebtorIBAN("11");
		
		PaymentRejectedResponse response = (PaymentRejectedResponse) initiatePaymentsService.initiatePayments(paymentInitiationRequest);
		//System.out.println(response);
		assertTrue(response!=null && TransactionStatus.Rejected.equals(response.getStatus()));
	}
	
	@Test
	public void testIsLimitExceededError_3() {
		
		BigDecimal amount = new BigDecimal(14);
		Long sumOfDigitsInDebtorAccountIBAN = new Long(12);
		Long lenghtOfDigitsInDebtorAccountIBAN = new Long(11);
		
		boolean isLimitExceeded = initiatePaymentsService.isLimitExceededError(amount, sumOfDigitsInDebtorAccountIBAN, lenghtOfDigitsInDebtorAccountIBAN);
		assertFalse(isLimitExceeded);
	}
	
	@Test
	public void testIsLimitExceededError_2() {
		
		BigDecimal amount = new BigDecimal(0);
		Long sumOfDigitsInDebtorAccountIBAN = new Long(12);
		Long lenghtOfDigitsInDebtorAccountIBAN = new Long(12);
		
		boolean isLimitExceeded = initiatePaymentsService.isLimitExceededError(amount, sumOfDigitsInDebtorAccountIBAN, lenghtOfDigitsInDebtorAccountIBAN);
		assertFalse(isLimitExceeded);
	}
	
	@Test
	public void testIsLimitExceededError_1() {
		
		BigDecimal amount = new BigDecimal(23.12);
		Long sumOfDigitsInDebtorAccountIBAN = new Long(12);
		Long lenghtOfDigitsInDebtorAccountIBAN = new Long(12);
		
		boolean isLimitExceeded = initiatePaymentsService.isLimitExceededError(amount, sumOfDigitsInDebtorAccountIBAN, lenghtOfDigitsInDebtorAccountIBAN);
		assertTrue(isLimitExceeded);
	}
	
	@Test
	public void testGetLengthOfDebtorAccountIBAN_2() {
		Long output = initiatePaymentsService.getLengthOfDebtorAccountIBAN(null);
		//System.out.println(output);
		assertTrue(output==null);
		
	}
	
	@Test
	public void testGetLengthOfDebtorAccountIBAN_1() {
		Long output = initiatePaymentsService.getLengthOfDebtorAccountIBAN("sadjahsdjsa");
		//System.out.println(output);
		assertTrue(output!=null && output.longValue()==11);
		
	}
	
	@Test
	public void testGetSumOfDebtorAccountIBAN_4() {
		Long output = initiatePaymentsService.getSumOfDebtorAccountIBAN("");
		//System.out.println(output);
		assertTrue(output!=null && output.longValue()==0);
	}
	
	@Test
	public void testGetSumOfDebtorAccountIBAN_3() {
		Long output = initiatePaymentsService.getSumOfDebtorAccountIBAN(null);
		//System.out.println(output);
		assertTrue(output==null);
	}
	
	@Test
	public void testGetSumOfDebtorAccountIBAN_2() {
		Long output = initiatePaymentsService.getSumOfDebtorAccountIBAN("sadjahsdjsa");
		//System.out.println(output);
		assertTrue(output!=null && output.longValue()==0);
	}
	
	@Test
	public void testGetSumOfDebtorAccountIBAN_1() {
		Long output = initiatePaymentsService.getSumOfDebtorAccountIBAN("asdas123KJG785");
		//System.out.println(output);
		assertTrue(output!=null && output.longValue()==26);
	}
	
	@Test
	public void testGetPaymentInitiationRequest() {		
		//System.out.println(testBeansCreatorUtil.getPaymentInitiationRequest());
		assertTrue(testBeansCreatorUtil.getPaymentInitiationRequest()!=null);
	}
	
	@Test
	public void testTestBeansCreatorUtilBeanCreation() {
		//System.out.println(testBeansCreatorUtil.toString());
		assertTrue(testBeansCreatorUtil!=null);
	}
	
	@Test
	public void testPaymentsUtilsBeanCreation() {
		//System.out.println(paymentsUtils.toString());
		assertTrue(paymentsUtils!=null);
	}
	
	@Test
	public void testInitiatePaymentsServiceBeanCreation() {
		//System.out.println(initiatePaymentsService.toString());
		assertTrue(initiatePaymentsService!=null);
	}

}

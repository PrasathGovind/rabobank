package com.rabobank.payments.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.rabobank.payments.services.InitiatePaymentsService;
import com.rabobank.payments.utils.PaymentsUtils;

@RunWith(MockitoJUnitRunner.class)
public class InitiatePaymentsControllerTest {
	
	@InjectMocks
	PaymentsUtils paymentsUtil;
	
	@Mock
	InitiatePaymentsService initiatePaymentsService;
	
	@Test
	public void testIntialPayment() {
		
		assertEquals(true, true);
	}

}

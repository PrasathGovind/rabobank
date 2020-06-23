package com.rabobank.payments.utils;


import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.rabobank.payments.testbeans.TestBeansCreatorUtil;

@RunWith(MockitoJUnitRunner.class)
public class PaymentsUtilsTest {
	
	@InjectMocks
	PaymentsUtils paymentsUtils;
	
	@Mock
	TestBeansCreatorUtil testBeansCreatorUtil;
	
	@Test
	public void testPaymentsUtils() {
		//System.out.println(paymentsUtils.toString());
		assertTrue(paymentsUtils!=null);
	}
	
	@Test
	public void testGetBeansUtil() {
		//System.out.println(testBeansCreatorUtil.toString());
		assertTrue(testBeansCreatorUtil!=null);
	}
	
	@Test
	public void testGenerateUUID() {
		String output = paymentsUtils.generateUUID();
		//System.out.println(output);
		assertTrue(output != null);
	}

}

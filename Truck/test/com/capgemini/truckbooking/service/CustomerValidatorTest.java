package com.capgemini.truckbooking.service;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerValidatorTest {
	@Test
	public void testIsValidCustomerId() {
		CustomerValidator obj=new CustomerValidator();
	    boolean result = obj.isValidCustomerId("A501");
	    assertTrue("Valid Cust ID", result );
	}
	@Test
	public void testIsInvalidCustomerId(){
		CustomerValidator obj=new CustomerValidator();
	    boolean result= obj.isValidCustomerId("12345");
	    assertFalse("Invalid Cust ID", result);
	}
	
	@Test
	public void testIsValidPhoneNumber(){
		CustomerValidator obj=new CustomerValidator();
		boolean result=obj.isValidPhoneNumber(9887445633L);
		assertTrue("Valid PhoneNumber", result);
	}
	
	@Test
	public void testIsInvalidPhoneNumber(){
		CustomerValidator obj=new CustomerValidator();
		boolean result=obj.isValidPhoneNumber(18874L);
		assertFalse("Invalid PhoneNumber", result);
	}
	
	@Test
	public void testIsValidDate(){
		CustomerValidator obj=new CustomerValidator();
		boolean result=obj.isValidDate("2017-06-02");
		assertTrue("Invalid date", result);
	}
	
}

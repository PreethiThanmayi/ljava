package com.capgemini.mps.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class CustomerValidatorTest {

	@Test
	public void testIsValidCustomerName() {
		assertTrue(new CustomerValidator().isValidCustomerName("Anand preetham"));
	}
	
	@Test
	public void testIsNotValidCustomerName() {
		assertFalse(new CustomerValidator().isValidCustomerName("Ravi Kumar XXXXXXXXXXX"));
	}
	@Test
	public void testIsValidEmail() {
	assertTrue(new CustomerValidator().isValidEmail("anand@cap.com"))	;
	}
	
	@Test
	public void testIsNotValidEmail() {
	assertFalse(new CustomerValidator().isValidEmail("anand@cap"))	;
	}

	@Test
	public void testIsValidPhoneNumber() {
	assertTrue(new CustomerValidator().isValidPhoneNumber(9640496251L))	;
}

}

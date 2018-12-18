package com.capgemini.truckbooking.service;

import java.util.regex.Pattern;
import java.util.HashMap;
import java.util.Map;
import  java.util.regex.*;
/**
 * 
 * @author Admin
 * This class validates customer details
 */
public class CustomerValidator {
		
	/**
	 * 
	 * @param customer
	 * @return true if customer ID is a sequence of an alphabet followed by 3 number,
	 *  and should begin with upper-case letter else return false
	 */
	public Boolean isValidCustomerId(String custId) {
		String regex= "^[A-Z]{1}[0-9]{3}$";
		Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(custId);
        return m.matches();
	}	
	/**
	 * 
	 * @param customer
	 * @return true if phone number is 10-digit number
	 * else returns false
	 */
	public Boolean isValidPhoneNumber(Long phoneNumber ) {
		String mobile=phoneNumber.toString();
		String regex="^[1-9][0-9]{9}$";
		return Pattern.matches(regex, mobile);
	}
	
	public Boolean isValidDate(CharSequence date ) {
		String dateOfTransport=date.toString();
		String regex="^[2][0][0-9]{2}-(1[0-2]|0[1-9])-(3[01]|[12][0-9]|0[1-9])$";
		return Pattern.matches(regex, dateOfTransport);
	}
	
	
}

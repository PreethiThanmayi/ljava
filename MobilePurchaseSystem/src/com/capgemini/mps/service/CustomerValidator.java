package com.capgemini.mps.service;


import java.util.regex.Pattern;


public class CustomerValidator {
			//turn true if customer name is a sequence of 20 alphabets and should begin with one or no space
			public Boolean isValidCustomerName(String name){
				String regex="^[A-Z][a-zA-Z]{0,19}$";
				return Pattern.matches(regex, name); 
			}
		
			//return true if email is valid ;else return false
			/*email is valid if
			 * email begins with either  digits or alphabets followed by one symbol..
			 */
			public boolean isValidEmail(String emailId){
				String regex="^[a-z0-9._]+[@][a-zA-Z]+[.][a-zA-Z]{2,3}$";
			return Pattern.matches(regex, emailId);
					}/*10 digits*/

			
			public Boolean isValidPhoneNumber(Long phoneNumber){
				String mobile=phoneNumber.toString();
				String regex="[1-9][0-9]{9}$";
				return Pattern.matches(regex, mobile);
			}//invoke true if all of the methods is true, else false
			
			}
		

	



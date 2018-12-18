package com.capgemini.truckbooking.exception;

public class BookingException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6738870095413400728L;
	private String message;
	
	public BookingException() {
		
	}

	public BookingException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "BookingException [message=" + message + "]";
	}
	
}

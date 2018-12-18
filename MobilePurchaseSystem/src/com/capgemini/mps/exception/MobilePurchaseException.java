package com.capgemini.mps.exception;

public class MobilePurchaseException extends Exception{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String message;
public MobilePurchaseException(){
	
}
public MobilePurchaseException(String message) {
	super();
	this.message = message;
}
public String getMessage() {
	return message;
}
@Override
public String toString() {
	return "MobilePurchaseSystemException [message=" + message + "]";
}
	
	
}

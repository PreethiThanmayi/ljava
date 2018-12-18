package com.capgemini.exception;

public class FlatException  extends Exception {
	
	String message;

	public FlatException() {
		super();
	}

	public FlatException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	@Override
	public String toString() {
		return "FlatException [message=" + message + "]";
	}
	

}

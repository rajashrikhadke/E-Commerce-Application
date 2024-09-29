package com.user;

public class EcommException extends RuntimeException {

	private String message;
	public EcommException (String message){
		super(message);
	}
}

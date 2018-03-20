package com.jschotte.swingy.utils;

@SuppressWarnings("serial")
public class customException extends RuntimeException {

	public customException(){
		super();
	}

	public customException(String message){
		super(message);
	}
}
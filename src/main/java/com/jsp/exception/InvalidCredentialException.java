package com.jsp.exception;

public class InvalidCredentialException extends RuntimeException {

	private String s="Incorect Entry";
	
	public InvalidCredentialException() 
	{
		
	}

	public InvalidCredentialException(String s) 
	{
		this.s = s;
	}

	@Override
	public String getMessage()
	{
		return s;
	}
}

package com.project.store.exception;

public class CreditCardValidationException extends RuntimeException {
	
    /*
	 *	This exception was made to handle any error caused by a wrong credit card and send a message of it. 
	 */
	
	private static final long serialVersionUID = 1L;

	public CreditCardValidationException(String message) {
        super(message);
    }
}
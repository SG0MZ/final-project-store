package com.project.store.exception;

public class CreditCardValidationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreditCardValidationException(String message) {
        super(message);
    }
}
package com.project.store.service;

import org.springframework.stereotype.Service;

import com.project.store.exception.CreditCardValidationException;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CreditCardValidationService {
	
	/*
	 * The following functions were created to validate a credit card which must be numbers 0 to 9 with 16 digits.
	 * Also it has to be different to the stolen credit cards saved in the list below. Otherwise it will throw an exception.
	 * 
	 * validate
	 * validateNumberOfDigits
	 * validateNotStolenCreditCard
	 */
	
    private static final String CREDIT_CARD_FORMAT = "^[0-9]{16}$";
    private static final Set<String> STOLEN_CREDIT_CARDS = new HashSet<>();

    public CreditCardValidationService() {
        STOLEN_CREDIT_CARDS.add("1111111111111111");
        STOLEN_CREDIT_CARDS.add("9999888877776666");
    }

    public void validate(String creditCardNumber) {
        validateNumberOfDigits(creditCardNumber);
        validateNotStolenCreditCard(creditCardNumber);
    }

    private void validateNumberOfDigits(String creditCardNumber) {
        if (!creditCardNumber.matches(CREDIT_CARD_FORMAT)) {
            throw new CreditCardValidationException(String.format("%s is invalid credit card", creditCardNumber));
        }
    }

    private void validateNotStolenCreditCard(String creditCardNumber) {
        System.out.println(STOLEN_CREDIT_CARDS.stream().collect(Collectors.joining()));
        System.out.println(creditCardNumber);
        if (STOLEN_CREDIT_CARDS.contains(creditCardNumber)) {
            throw new CreditCardValidationException(String.format("%s is a stolen credit card", creditCardNumber));
        }
    }
}

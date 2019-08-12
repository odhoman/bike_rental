package com.intive.fdv.rental.exception.validation;

import java.util.List;

import com.intive.fdv.rental.exception.RentalValidationException;

public class MultipleRentalValidationException extends RentalValidationException{

	private final List<RentalValidationException> exceptions;
	
	public MultipleRentalValidationException(String message, List<RentalValidationException> exceptions) {
		super(message);
		this.exceptions = exceptions;
	}

	public List<RentalValidationException> getExceptions() {
		return exceptions;
	}
}

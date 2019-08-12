package com.intive.fdv.rental.exception.service;

import com.intive.fdv.rental.exception.validation.MultipleRentalValidationException;

public class RentalServiceValidationException extends RentalServiceException {

	public RentalServiceValidationException(String message, MultipleRentalValidationException e) {
		super(message,e);
	}
}

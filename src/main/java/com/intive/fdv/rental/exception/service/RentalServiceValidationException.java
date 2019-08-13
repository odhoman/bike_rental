package com.intive.fdv.rental.exception.service;

import com.intive.fdv.rental.exception.validation.MultipleRentalValidationException;

/** Validation Exception in the service */

public class RentalServiceValidationException extends RentalServiceException {

	public RentalServiceValidationException(String message, MultipleRentalValidationException e) {
		super(message,e);
	}
}

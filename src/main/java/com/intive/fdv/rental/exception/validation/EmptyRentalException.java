package com.intive.fdv.rental.exception.validation;

import com.intive.fdv.rental.exception.RentalException;

/** Exception For an empty rental */

public class EmptyRentalException extends RentalException {
	
	public EmptyRentalException(String message){
		super(message);
	}

}

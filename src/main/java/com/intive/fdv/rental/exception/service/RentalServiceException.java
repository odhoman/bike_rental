package com.intive.fdv.rental.exception.service;

public class RentalServiceException extends Exception {

	public RentalServiceException(String message) {
		super(message);
	}

	public RentalServiceException(Throwable e) {
		super(e);
	}

	public RentalServiceException(String message, Throwable e) {
		super(message, e);
	}

}

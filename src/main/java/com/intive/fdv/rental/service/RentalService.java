package com.intive.fdv.rental.service;

import com.intive.fdv.rental.exception.service.RentalServiceException;
import com.intive.fdv.rental.mode.Item.RentalItem;
import com.intive.fdv.rental.mode.Item.RentalType;
import com.intive.fdv.rental.mode.Item.RentalTypeEnum;
import com.intive.fdv.rental.mode.combo.RentalCombo;
import com.intive.fdv.rental.mode.combo.RentalComboEnum;

/** Service for the rental */

public interface RentalService {

	/** Creates a new empty rental bikes */
	
	public abstract RentalCombo createNewRentalCombo(RentalComboEnum rC) throws RentalServiceException;
	
	/** Creates a new empty rental type */
	
	public abstract RentalType createRentalType(RentalTypeEnum rT) throws RentalServiceException;

	/** Executes Rentals validations */
	
	public void validateRentalCombo(RentalCombo rC) throws RentalServiceException;

	/**  Adds a Rental bike to the rental combo */
	
	public void addRentalItem(RentalItem item, RentalCombo rentalCombo);
	
}

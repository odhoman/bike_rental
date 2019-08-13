package com.intive.fdv.rental.mode.combo.validation;

import com.intive.fdv.rental.exception.RentalValidationException;
import com.intive.fdv.rental.mode.combo.RentalCombo;

/** Validates a condition in the rental */

public interface RentalComboValidator {
	
	/** Validates a condition in the rental 
	 *  throws a validation exception when this conditions occurs */
	
	public void validate(RentalCombo rC) throws RentalValidationException;

}

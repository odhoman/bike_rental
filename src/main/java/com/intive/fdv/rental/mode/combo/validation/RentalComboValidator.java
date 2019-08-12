package com.intive.fdv.rental.mode.combo.validation;

import com.intive.fdv.rental.exception.RentalValidationException;
import com.intive.fdv.rental.mode.combo.RentalCombo;

public interface RentalComboValidator {
	
	public void validate(RentalCombo rC) throws RentalValidationException;

}

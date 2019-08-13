package com.intive.fdv.rental.exception.validation;

import com.intive.fdv.rental.mode.combo.validation.NoItemRentalComboValidator;

/** Validation Manager por Regular rental */

public class RegularComboValidatorManager extends ComboValidationManager {
	
	public RegularComboValidatorManager(){
		addValidator(new NoItemRentalComboValidator());
	}

}

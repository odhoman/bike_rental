package com.intive.fdv.rental.exception.validation;

import com.intive.fdv.rental.mode.combo.validation.FamilyRentalItemsNumberRentalComboValidator;
import com.intive.fdv.rental.mode.combo.validation.NoItemRentalComboValidator;

/** Validation Manager por Family rental */

public class FamilyComboValidationManager extends ComboValidationManager {
	
	public FamilyComboValidationManager(){
		addValidator(new NoItemRentalComboValidator());
		addValidator(new FamilyRentalItemsNumberRentalComboValidator());
	}

}

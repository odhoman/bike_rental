package com.intive.fdv.rental.mode.combo.validation;

import com.intive.fdv.rental.exception.RentalValidationException;
import com.intive.fdv.rental.mode.combo.RentalCombo;

public class FamilyRentalItemsNumberRentalComboValidator implements RentalComboValidator {

	@Override
	public void validate(RentalCombo rC) throws RentalValidationException {

		if (!rC.getRentals().isEmpty() && (rC.getRentals().size() < 3 || rC.getRentals().size() > 5))
			throw new RentalValidationException("Family Rental, is a promotion that can include from 3 to 5 Rentals");

	}

}

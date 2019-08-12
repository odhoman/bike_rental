package com.intive.fdv.rental.mode.combo.validation;

import com.intive.fdv.rental.exception.RentalValidationException;
import com.intive.fdv.rental.mode.combo.RentalCombo;

public class NoItemRentalComboValidator implements RentalComboValidator {

	@Override
	public void validate(RentalCombo rC) throws RentalValidationException {
		if (rC.getRentals().isEmpty())
			throw new RentalValidationException("No Item Rental Found!");

	}

}

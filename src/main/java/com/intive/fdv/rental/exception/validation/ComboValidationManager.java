package com.intive.fdv.rental.exception.validation;

import java.util.ArrayList;
import java.util.List;

import com.intive.fdv.rental.exception.RentalValidationException;
import com.intive.fdv.rental.mode.combo.RentalCombo;
import com.intive.fdv.rental.mode.combo.validation.RentalComboValidator;

/** Validation Manager for the rental */

public class ComboValidationManager {

	private List<RentalComboValidator> rCVs = new ArrayList<>();
	
	protected void addValidator(RentalComboValidator rCV){
		rCVs.add(rCV);
	}
	
	public void validateCombo(RentalCombo rC) throws MultipleRentalValidationException {

		List<RentalValidationException> validations = new ArrayList<>();

		for (RentalComboValidator rCV : rCVs) {
			try {
				rCV.validate(rC);
			} catch (RentalValidationException e) {
				validations.add(e);
			}
		}

		if (!validations.isEmpty())
			throw new MultipleRentalValidationException("There one or more Rental Combo Validation Exceptions",
					validations);
	}
	
}

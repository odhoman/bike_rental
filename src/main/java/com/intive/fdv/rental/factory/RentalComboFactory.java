package com.intive.fdv.rental.factory;

import com.intive.fdv.rental.exception.RentalComboNotImplemented;
import com.intive.fdv.rental.exception.RentalException;
import com.intive.fdv.rental.exception.validation.EmptyRentalException;
import com.intive.fdv.rental.exception.validation.FamilyComboValidationManager;
import com.intive.fdv.rental.exception.validation.RegularComboValidatorManager;
import com.intive.fdv.rental.mode.combo.RentalCombo;
import com.intive.fdv.rental.mode.combo.RentalComboEnum;
import com.intive.fdv.rental.mode.combo.concept.FamilyConceptApplyer;

/** Factory for new empty rental */

public class RentalComboFactory {

	private RentalComboFactory() {
		super();
	}

	/** Return new empty rental */
	
	public static RentalCombo getRentalCombo(RentalComboEnum rCE) throws RentalException {

		if (rCE == null)
			throw new EmptyRentalException("Have to choose a Rental Combo");

		if (rCE.equals(RentalComboEnum.REGULAR_COMBO_RENTAL)) {
			return new RentalCombo(new RegularComboValidatorManager());
		} else if (rCE.equals(RentalComboEnum.FAMILY_COMBO_RENTAL)) {
			return new RentalCombo(new FamilyComboValidationManager(), new FamilyConceptApplyer());
		} else {
			throw new RentalComboNotImplemented("Rental Combo Not Implemented");
		}
	}
}

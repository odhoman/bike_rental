package com.intive.fdv.rental.factory;

import java.util.Arrays;

import com.intive.fdv.rental.exception.RentalComboNotImplemented;
import com.intive.fdv.rental.exception.RentalException;
import com.intive.fdv.rental.exception.validation.EmptyRentalException;
import com.intive.fdv.rental.mode.combo.FamilyComboConceptAmountApplicable;
import com.intive.fdv.rental.mode.combo.RentalCombo;
import com.intive.fdv.rental.mode.combo.RentalComboEnum;
import com.intive.fdv.rental.mode.combo.validation.FamilyRentalItemsNumberRentalComboValidator;
import com.intive.fdv.rental.mode.combo.validation.NoItemRentalComboValidator;

public class RentalComboFactory {

	private RentalComboFactory() {
		super();
	}

	public static RentalCombo getRentalCombo(RentalComboEnum rCE) throws RentalException {

		if (rCE == null)
			throw new EmptyRentalException("Have to choose a Rental Combo");

		if (rCE.equals(RentalComboEnum.REGULAR_COMBO_RENTAL)) {
			return new RentalCombo(Arrays.asList(new NoItemRentalComboValidator()));
		} else if (rCE.equals(RentalComboEnum.FAMILY_COMBO_RENTAL)) {
			return new RentalCombo(
					Arrays.asList(new NoItemRentalComboValidator(), new FamilyRentalItemsNumberRentalComboValidator()),
					Arrays.asList(new FamilyComboConceptAmountApplicable()));
		} else {
			throw new RentalComboNotImplemented("Rental Combo Not Implemented");
		}
	}
}

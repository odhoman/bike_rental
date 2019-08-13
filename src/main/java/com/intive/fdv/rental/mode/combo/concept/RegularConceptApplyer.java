package com.intive.fdv.rental.mode.combo.concept;

import java.util.ArrayList;
import java.util.List;

import com.intive.fdv.rental.mode.combo.ComboConceptAmountApplicable;

/** Applies concept to the total price on a Regular Rental */

public class RegularConceptApplyer implements ConceptAmountApplyer{

	@Override
	public List<ComboConceptAmountApplicable> getConceptosAmountApplicable() {
		return new ArrayList<>();
	}

}

package com.intive.fdv.rental.mode.combo.concept;

import java.util.ArrayList;
import java.util.List;
import com.intive.fdv.rental.mode.combo.*;

/** Applies concept to the total price on a Family Rental */

public class FamilyConceptApplyer implements ConceptAmountApplyer {

	@Override
	public List<ComboConceptAmountApplicable> getConceptosAmountApplicable() {

		List<ComboConceptAmountApplicable> list = new ArrayList<>();
		list.add(new FamilyComboConceptAmountApplicable());

		return list;
	}

}

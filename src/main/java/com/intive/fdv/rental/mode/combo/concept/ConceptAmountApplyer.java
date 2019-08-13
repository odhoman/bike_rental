package com.intive.fdv.rental.mode.combo.concept;

import java.util.List;

import com.intive.fdv.rental.mode.combo.ComboConceptAmountApplicable;

/** Applies concept to the total price */

public interface ConceptAmountApplyer {
	
	/** Applies concepts to the total price. These concepts can lower or raise the price */
	
	public default Double getAmountTotalApplicable(final Double totalPrice) {

		List<ComboConceptAmountApplicable> cCAA = getConceptosAmountApplicable();
		
		if (cCAA.isEmpty())
			return 0D;

		return cCAA.stream().mapToDouble(c -> c.getAmountApplyCombo(totalPrice)).sum();
	}

	/** Return a list of aplicable concepts */
	
	public abstract List<ComboConceptAmountApplicable> getConceptosAmountApplicable();
}

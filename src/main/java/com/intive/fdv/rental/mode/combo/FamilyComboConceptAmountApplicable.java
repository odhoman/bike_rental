package com.intive.fdv.rental.mode.combo;

public class FamilyComboConceptAmountApplicable implements ComboConceptAmountApplicable {

	private final static double FAMILY_RENTAL_PROCENT_DISCOUNT = 30D;
	
	@Override
	public String getComboApplicableType() {
		return "Family Rental Discount";
	}

	@Override
	public String getComboApplicableDescription() {
		return "Family Rental Discount - "+FAMILY_RENTAL_PROCENT_DISCOUNT+"% discount";
	}

	public Double getAmountApplyCombo(Double totalAmount) {
		return calculatePercentage(FAMILY_RENTAL_PROCENT_DISCOUNT, totalAmount);
	}

}

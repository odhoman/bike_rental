package com.intive.fdv.rental.mode.combo;

/** The concept applicable to the total price */

public interface ComboConceptAmountApplicable {
	
	/** Returns the concepto type name */
	
	public String getComboApplicableType();
	
	/** Returns the concepto type description */
	
	public String getComboApplicableDescription();
	
	/** Return the amount to apply to the final price */
	
	public Double getAmountApplyCombo(Double totalAmount);
	
	/** Calculates the porcentage applicable  */
	
    public default double calculatePercentage(double obtained, double total) {
        return obtained * total / 100;
    }
	
}

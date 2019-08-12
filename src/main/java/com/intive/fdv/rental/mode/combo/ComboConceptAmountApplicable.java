package com.intive.fdv.rental.mode.combo;

public interface ComboConceptAmountApplicable {
	
	public String getComboApplicableType();
	
	public String getComboApplicableDescription();
	
	public Double getAmountApplyCombo(Double totalAmount);
	
    public default double calculatePercentage(double obtained, double total) {
        return obtained * total / 100;
    }
	
}

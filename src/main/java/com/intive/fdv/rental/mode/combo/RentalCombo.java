package com.intive.fdv.rental.mode.combo;

import java.util.ArrayList;
import java.util.List;

import com.intive.fdv.rental.exception.validation.ComboValidationManager;
import com.intive.fdv.rental.exception.validation.MultipleRentalValidationException;
import com.intive.fdv.rental.mode.Item.RentalItem;
import com.intive.fdv.rental.mode.combo.concept.ConceptAmountApplyer;
import com.intive.fdv.rental.mode.combo.concept.RegularConceptApplyer;

/** Rental bikes */

public class RentalCombo {

	private List<RentalItem> rentals = new ArrayList<>();
	private ComboValidationManager validatorManager;
	private ConceptAmountApplyer conceptAmountApplyer;

	public RentalCombo(ComboValidationManager validatorManager) {
		super();
		this.validatorManager = validatorManager;
		this.conceptAmountApplyer = new RegularConceptApplyer(); 
	}

	public RentalCombo(ComboValidationManager validatorManager, ConceptAmountApplyer conceptAmountApplyer) {
		super();
		this.validatorManager = validatorManager;
		this.conceptAmountApplyer = conceptAmountApplyer;
	}

	public List<RentalItem> getRentals() {
		return rentals;
	}

	public void addRental(RentalItem item) {
		rentals.add(item);
	}
	
	/** Returns the total price adding the amounts of each item. */
	
	protected Double getTotalPriceRentalItems() {
		return rentals.stream().mapToDouble(RentalItem::getTotal).sum();
	}
	
	/** Return the final price applying differents conceps to the total price */
	
	public Double getTotalPrice() {
		Double totalPrice = getTotalPriceRentalItems();
		Double aux = getAmountTotalApplicable(totalPrice);
		return totalPrice - aux;
	}
	
	/** Apply differents conceps to the total price */
	
	protected Double getAmountTotalApplicable(final Double totalPrice) {
		return conceptAmountApplyer.getAmountTotalApplicable(totalPrice);
	}
	/** Validate the Rental */
	
	public void validateCombo() throws MultipleRentalValidationException {
		validatorManager.validateCombo(this);
	}

}

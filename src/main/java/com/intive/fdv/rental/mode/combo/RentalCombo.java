package com.intive.fdv.rental.mode.combo;

import java.util.ArrayList;
import java.util.List;

import com.intive.fdv.rental.exception.RentalValidationException;
import com.intive.fdv.rental.exception.validation.MultipleRentalValidationException;
import com.intive.fdv.rental.mode.Item.RentalItem;
import com.intive.fdv.rental.mode.combo.validation.RentalComboValidator;

public class RentalCombo {

	private List<RentalItem> rentals = new ArrayList<>();
	private List<RentalComboValidator> rCVs = new ArrayList<>();
	private List<ComboConceptAmountApplicable> cCAA = new ArrayList<>();

	public RentalCombo(List<RentalComboValidator> rCVs) {
		super();
		this.rCVs = rCVs;
	}

	public RentalCombo(List<RentalComboValidator> rCVs, List<ComboConceptAmountApplicable> cCAA) {
		super();
		this.rCVs = rCVs;
		this.cCAA = cCAA;
	}

	public final List<ComboConceptAmountApplicable> getComboConceptsAmountApplicable() {
		return cCAA;
	}

	public List<RentalItem> getRentals() {
		return rentals;
	}

	public void addRental(RentalItem item) {
		rentals.add(item);
	}

	protected Double getTotalPriceRentalItems() {
		return rentals.stream().mapToDouble(RentalItem::getTotal).sum();
	}

	public Double getTotalPrice() {
		Double totalPrice = getTotalPriceRentalItems();
		Double aux = getAmountTotalApplicable(totalPrice);
		return totalPrice - aux;
	}

	protected Double getAmountTotalApplicable(final Double totalPrice) {

		if (cCAA.isEmpty())
			return 0D;

		return cCAA.stream().mapToDouble(c -> c.getAmountApplyCombo(totalPrice)).sum();
	}

	public void validateCombo() throws MultipleRentalValidationException {

		List<RentalValidationException> validations = new ArrayList<>();

		for (RentalComboValidator rCV : rCVs) {
			try {
				rCV.validate(this);
			} catch (RentalValidationException e) {
				validations.add(e);
			}
		}

		if (!validations.isEmpty())
			throw new MultipleRentalValidationException("There one or more Rental Combo Validation Exceptions",
					validations);
	}

}

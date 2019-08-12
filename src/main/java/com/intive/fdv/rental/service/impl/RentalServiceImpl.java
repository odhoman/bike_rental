package com.intive.fdv.rental.service.impl;

import org.springframework.stereotype.Component;

import com.intive.fdv.rental.exception.RentalComboNotImplemented;
import com.intive.fdv.rental.exception.RentalException;
import com.intive.fdv.rental.exception.service.RentalServiceException;
import com.intive.fdv.rental.exception.service.RentalServiceValidationException;
import com.intive.fdv.rental.exception.service.WrongComboSelectedServiceException;
import com.intive.fdv.rental.exception.service.WrongRentalTypeSelectedServiceException;
import com.intive.fdv.rental.exception.validation.EmptyRentalException;
import com.intive.fdv.rental.exception.validation.MultipleRentalValidationException;
import com.intive.fdv.rental.factory.RentalComboFactory;
import com.intive.fdv.rental.factory.RentalTypeFactory;
import com.intive.fdv.rental.mode.Item.RentalItem;
import com.intive.fdv.rental.mode.Item.RentalType;
import com.intive.fdv.rental.mode.Item.RentalTypeEnum;
import com.intive.fdv.rental.mode.combo.RentalCombo;
import com.intive.fdv.rental.mode.combo.RentalComboEnum;
import com.intive.fdv.rental.service.RentalService;

@Component("rentalService")
public class RentalServiceImpl implements RentalService {

	@Override
	public RentalCombo createNewRentalCombo(RentalComboEnum rC) throws RentalServiceException {
		try {
			return RentalComboFactory.getRentalCombo(rC);
		} catch (EmptyRentalException | RentalComboNotImplemented e) {
			throw new WrongComboSelectedServiceException("Wrong combo selected", e);
		} catch (RentalException e) {
			throw new RentalServiceException("Error creating a rental combo", e);
		}
	}

	@Override
	public RentalType createRentalType(RentalTypeEnum rT) throws RentalServiceException {
		try {
			return RentalTypeFactory.getRentalType(rT);
		} catch (RentalException e) {
			throw new WrongRentalTypeSelectedServiceException("Wrong rental type selected", e);
		}
	}

	public void addRentalItem(RentalItem item, RentalCombo rentalCombo) {
		rentalCombo.addRental(item);
	}

	@Override
	public void validateRentalCombo(RentalCombo rC) throws RentalServiceException {
		try {
			rC.validateCombo();
		} catch (MultipleRentalValidationException e) {
			throw new RentalServiceValidationException("Validations Error", e);
		}
	}
}

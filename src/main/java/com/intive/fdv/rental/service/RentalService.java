package com.intive.fdv.rental.service;

import com.intive.fdv.rental.exception.service.RentalServiceException;
import com.intive.fdv.rental.mode.Item.RentalItem;
import com.intive.fdv.rental.mode.Item.RentalType;
import com.intive.fdv.rental.mode.Item.RentalTypeEnum;
import com.intive.fdv.rental.mode.combo.RentalCombo;
import com.intive.fdv.rental.mode.combo.RentalComboEnum;


public interface RentalService {

	public abstract RentalCombo createNewRentalCombo(RentalComboEnum rC) throws RentalServiceException;
	
	public abstract RentalType createRentalType(RentalTypeEnum rT) throws RentalServiceException;

	public void validateRentalCombo(RentalCombo rC) throws RentalServiceException;

	public void addRentalItem(RentalItem item, RentalCombo rentalCombo);
	
}

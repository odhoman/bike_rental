package com.intive.fdv.rental.factory;

import com.intive.fdv.rental.exception.RentalException;
import com.intive.fdv.rental.exception.TypeRentalNotImplementedException;
import com.intive.fdv.rental.exception.validation.EmptyRentalException;
import com.intive.fdv.rental.mode.Item.RentalType;
import com.intive.fdv.rental.mode.Item.RentalTypeEnum;

public class RentalTypeFactory {

	private RentalTypeFactory() {
		super();
	}

	public static RentalType getRentalType(RentalTypeEnum rTE) throws RentalException {

		if (rTE == null)
			throw new EmptyRentalException("Have to choose a Rental type");

		if (rTE.equals(RentalTypeEnum.RENTAL_BY_HOURS))
			return createRentalByTypeAndCharge(RentalTypeEnum.RENTAL_BY_HOURS, 5D);
		else if (rTE.equals(RentalTypeEnum.RENTAL_BY_DAY))
			return createRentalByTypeAndCharge(RentalTypeEnum.RENTAL_BY_DAY, 20D);
		else if (rTE.equals(RentalTypeEnum.RENTAL_BY_WEEK))
			return createRentalByTypeAndCharge(RentalTypeEnum.RENTAL_BY_WEEK, 60D);

		throw new TypeRentalNotImplementedException("Type Rental " + rTE.getTypeDesc() + "Not Implemented");

	}

	private static RentalType createRentalByTypeAndCharge(RentalTypeEnum rtE, Double charge) {
		return new RentalType(rtE.getTypeDesc(), charge);
	}
}

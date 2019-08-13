package com.intive.fdv.rental.mode.Item;

/** Rental Type */

public enum RentalTypeEnum {

	RENTAL_BY_DAY("Rental By Day"), RENTAL_BY_HOURS("Rental By Hours"), RENTAL_BY_WEEK("Rental By Week"), RENTAL_NOT_IMPLEMENTED("Rental Not Implemented");

	private RentalTypeEnum(String typeDesc) {
		this.typeDesc = typeDesc;
	}

	private String typeDesc;

	public String getTypeDesc() {
		return typeDesc;
	}
}

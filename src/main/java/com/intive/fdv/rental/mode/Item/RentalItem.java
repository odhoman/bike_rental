package com.intive.fdv.rental.mode.Item;

import com.intive.fdv.rental.mode.bike.BikeEnum;

/** The rental of one bicycle in the final rent */

public class RentalItem {

	private BikeEnum bikeEnum;
	private RentalType rentalType;
	private int hours;

	public RentalItem(BikeEnum BikeEnum, RentalType rentalType, int hours) {
		super();
		this.bikeEnum = BikeEnum;
		this.rentalType = rentalType;
		this.hours = hours;
	}

	public BikeEnum getBikeEnum() {
		return bikeEnum;
	}

	public RentalType getRentalType() {
		return rentalType;
	}

	public void setRentalType(RentalType rentalType) {
		this.rentalType = rentalType;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Double getTotal() {
		return hours * rentalType.getCharge();
	}

}

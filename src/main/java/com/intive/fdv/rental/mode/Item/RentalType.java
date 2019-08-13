package com.intive.fdv.rental.mode.Item;

/** Contains the name and the charge of type rental */

public class RentalType {

	private String typeName;
	private Double charge;
	
	public RentalType(String typeName, Double charge) {
		super();
		this.typeName = typeName;
		this.charge = charge;
	}

	public String getTypeName() {
		return typeName;
	}
	
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public Double getCharge() {
		return charge;
	}
	
}

package com.fidelity.warehouse;

import java.time.LocalDate;

public class Gadget extends Product {
	
	private int numberInOnePack;
	
	public Gadget(String description, double unitPrice, int numberInOnePack) {
		super(description, unitPrice);
		this.numberInOnePack = numberInOnePack;
	}
	
	@Override
	public double calculateValue(LocalDate date) {
		if (numberInOnePack <= 0) {
			throw new IllegalArgumentException("Number in one Pack must be Positive!");
		} else
		return numberInOnePack*getUnitPrice();
	}

}

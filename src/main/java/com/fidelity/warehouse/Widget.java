package com.fidelity.warehouse;

import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;

public class Widget extends Product {
	
	private LocalDate expirationDate;

	public Widget(String description, double unitPrice, LocalDate expirationDate) {
		super(description, unitPrice);
		this.expirationDate = expirationDate;
		
	}
	
	public int determineExpired(LocalDate date) {
		//long difference = ChronoUnit.HOURS.between(expirationDate, date);
		if (date.isBefore(expirationDate)) {
			return 1;
		}
		else return 0;
	}

	@Override
	public double calculateValue(LocalDate date) {
		if (determineExpired(date) == 0) {
			return 0;
		}
		else return getUnitPrice();
	}
}

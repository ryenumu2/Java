package com.fidelity.warehouse;

import java.time.LocalDate;

public abstract class Product {
	private String description;
	private double unitPrice;
	
	public Product(String description, double unitPrice) {
		super();
		this.setDescription(description);
		this.unitPrice = unitPrice;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public abstract double calculateValue(LocalDate date);
}

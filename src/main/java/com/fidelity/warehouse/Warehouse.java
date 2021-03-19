package com.fidelity.warehouse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Warehouse {
	private List<Product> products;
	private static int maxCapacity = 5;
	
	public Warehouse() {
		if (maxCapacity < 0) {
			throw new IllegalStateException("Warehouse cannot have a negative Capacity!");
		}
		else 
		products = new ArrayList<>(maxCapacity);
	}
	
	public int getTotalNumberOfProducts() {
		
		return products.size();
	}
	
	public void addProduct(Product product) {
		if (getTotalNumberOfProducts() >= maxCapacity) {
			throw new IllegalStateException("Warehouse is Full!");
		}
		else products.add(product);
	}
	
	public void removeProduct(Product product) throws WarehouseException {
		boolean contains = products.remove(product);
		
		if(!contains) {
			throw new WarehouseException("Product not in Warehouse!");
		}
	}
	
	public int getMaxCapacity() {
		return maxCapacity;
	}
	
	public int getNumberAvailableSpaces() {
		return getMaxCapacity()-getTotalNumberOfProducts();
	}
	
	public double getTotalValue(LocalDate date, List<Product> products) {
		double total = 0.0;
		for (Product pr : products) {
		total += pr.calculateValue(date);
		}
		return total;
	}
}
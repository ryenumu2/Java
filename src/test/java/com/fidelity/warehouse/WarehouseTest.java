package com.fidelity.warehouse;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WarehouseTest {
	Warehouse warehouse;
	Widget widget;
	Gadget gadget;
	
	Product ToyRobot;
	Product Apple;
	
	@BeforeEach
	void setUp() throws Exception {
		warehouse = new Warehouse();
	}

	@Test
	void testProductCreation() {
		assertNotNull(warehouse);
	}
	
	@Test
	void testNoArgConstructorCreatesEmptyList() {
		int expected = 0;
		int actual = warehouse.getTotalNumberOfProducts();
		assertEquals(expected, actual);
	} 
	
	@Test
	void testAddProduct() {
		ToyRobot = new Gadget("Toy Robot", 15.00, 4);
		int originalSize = warehouse.getTotalNumberOfProducts();
		warehouse.addProduct(ToyRobot);	
		int newSize = warehouse.getTotalNumberOfProducts();
		assertEquals(originalSize+1, newSize);
	}
	
	@Test
	void testRemoveProduct() throws WarehouseException {
		Apple = new Widget("Apple", 3.25, LocalDate.of(2021, 5, 2));
		warehouse.addProduct(Apple);
		int originalSize = warehouse.getTotalNumberOfProducts();
		warehouse.removeProduct(Apple);	
		int newSize = warehouse.getTotalNumberOfProducts();
		assertEquals(originalSize-1, newSize);
	}
	
	@Test
	void testRemoveNonExistentRecordingThrowsException() {
		Exception e = assertThrows(WarehouseException.class, () -> {
			warehouse.removeProduct(Apple);
		});
		assertEquals("Product not in Warehouse!", e.getMessage());
	}
	
	/*
	 * Didn't finish
	 
	@Test
	void testTotalValue() {
		double expected = warehouse.getTotalValue(LocalDate.of(2021, 5, 1), );
	}
	*/

}

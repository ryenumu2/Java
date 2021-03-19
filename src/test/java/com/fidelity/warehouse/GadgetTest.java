package com.fidelity.warehouse;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GadgetTest {
	Gadget Bionicle;
	Gadget Pokemon;
	
	@BeforeEach
	void setUp() throws Exception {
		Bionicle = new Gadget("Toy Robot", 15.00, 4);
		Pokemon = new Gadget("Card", 8.00, -8);
	}

	@Test
	void testCalculateValue() {
		double expected = 60.00;
		double actual = Bionicle.calculateValue(LocalDate.of(2021, 3, 20));
		assertEquals(expected, actual);
	}
	
	//negative Test

	@Test
	void testCalculateNegativeValue() {
		Exception e = assertThrows(IllegalArgumentException.class, () -> {
			Pokemon.calculateValue(LocalDate.of(2021, 3, 16));
		});
		assertEquals("Number in one Pack must be Positive!", e.getMessage());
	}

}

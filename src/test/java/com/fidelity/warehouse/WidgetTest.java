package com.fidelity.warehouse;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WidgetTest {

	Widget Apple;
	
	@BeforeEach
	void setUp() throws Exception {
		Apple = new Widget("Apple", 3.25, LocalDate.of(2021, 5, 2));
	}

	@Test
	void testDetermineNotExpiredCalculateValue() {
		double expected = 3.25;
		double actual = Apple.calculateValue(LocalDate.of(2021, 3, 20));
		assertEquals(expected, actual);
	}
	
	@Test
	void testDetermineExpiredCalculateValue() {
		double expected = 0;
		double actual = Apple.calculateValue(LocalDate.of(2022, 3, 20));
		assertEquals(expected, actual);
	}
}

package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RateTest {

	@Test
	void Rate() {
		Rate rate = new Rate(0);
		rate.setRate(-5);
		rate.setRate(10);
		rate.setRate(5);
		assertEquals(rate.getRate(), 5);
	}

}

package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import code.StringCalculator;

class StringCalculatorTest {

	StringCalculator cal = new StringCalculator();
	
	@Test
	void sumTwoNumbersSeperatedByComma() {
		assertEquals(3, cal.add("1,2"));
	}
	@Test
	void sumEmptyString() {
		assertEquals(0, cal.add(""));
	}
	@Test
	void sumOneNumber() {
		assertEquals(1, cal.add("1"));
	}
	@Test
	void sumFourNumbersSeperatedByComma() {
		assertEquals(9, cal.add("1,2,4,2"));
	}
	@Test
	void sumThreeNumbersSeperatedByCommaAndNewline() {
		assertEquals(6, cal.add("1\n2,3"));
	}
	@Test
	void sumTwoNumbersSeperatedByAnyDelimiter() {
		assertEquals(3, cal.add("//;\n1;2"));
	}

}

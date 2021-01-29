package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
	@Test
	void throwExceptionWhenAddingNegativeNumber() {
		Exception ex = assertThrows(RuntimeException.class, ()->cal.add("1,-3"));
		String desiredMsg = "negatives not allowed - -3,";
		String resultMsg = ex.getMessage();
		assertTrue(desiredMsg.equals(resultMsg));
	}
	@Test
	void throwExceptionWhenAddingTwoNegativeNumbers() {
		Exception ex = assertThrows(RuntimeException.class, ()->cal.add("-1,-3"));
		String desiredMsg = "negatives not allowed - -1,-3,";
		String resultMsg = ex.getMessage();
		assertTrue(desiredMsg.equals(resultMsg));
	}
	@Test
	void throwExceptionWhenAddingNegativeNumberWithCustomDelimiter() {
		Exception ex = assertThrows(RuntimeException.class, ()->cal.add("//;\n1;-2"));
		String desiredMsg = "negatives not allowed - -2,";
		String resultMsg = ex.getMessage();
		assertTrue(desiredMsg.equals(resultMsg));
	}
	@Test
	void ignoreNumberBiggerThanThousand() {
		assertEquals(2, cal.add("2,1001"));
	}
	@Test
	void sumThreeNumbersSeperatedByAnyDelimiterOfAnyLength() {
		assertEquals(6, cal.add("//[***]\n1***2***3"));
	}
	@Test
	void sumThreeNumbersSeperatedByDifferentDelimiter() {
		assertEquals(6, cal.add("//[*][%]\n1*2%3"));
	}
}

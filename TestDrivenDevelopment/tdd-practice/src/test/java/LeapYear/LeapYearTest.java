package LeapYear;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import LeapYear.YearUtil;

public class LeapYearTest {

	YearUtil yearUtil;

	@Before
	public void setup() {
		yearUtil = new YearUtil();
	}

	@Test
	public void shouldReturnFalseForNotDivisibleBy4() {
		assertEquals(false, yearUtil.isLeapYear(2005));
	}

	@Test
	public void shouldReturnTrueForDivisibleBy4AndNotBy100Or400() {
		assertEquals(true, yearUtil.isLeapYear(2004));
	}

	@Test
	public void shouldReturnTrueForDivisibleBy100and400() {
		assertEquals(true, yearUtil.isLeapYear(800));
	}

	@Test
	public void shouldReturnFalseForDivisibleBy100Not400() {
		assertEquals(false, yearUtil.isLeapYear(500));
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldShowErrorMessageForNegativeNumber() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Negative year is not a valid input");
		assertEquals(false, yearUtil.isLeapYear(-2005));
	}

	/*
	 * @Test public void shouldShowErrorMessageForNullArgument() {
	 * thrown.expect(IllegalArgumentException.class);
	 * thrown.expectMessage("Null is not a valid input"); assertEquals(false,
	 * yearUtil.isLeapYear(null)); }
	 * 
	 * @Test public void shouldShowErrorMessageForNonNumberArgument() {
	 * thrown.expect(IllegalArgumentException.class);
	 * thrown.expectMessage("Argument type should be Long"); assertEquals(false,
	 * yearUtil.isLeapYear("string")); }
	 */

}

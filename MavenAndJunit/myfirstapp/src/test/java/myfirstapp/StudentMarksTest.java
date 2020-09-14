package myfirstapp;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StudentMarksTest {

	@Test
	public void testGetTotakMethod() {
		StudentMarks s1 = new StudentMarks("Sam", 15, 25, 50);
		int result = s1.getTotal();
		// assertTrue("result can not be negative", result > 0);
		assertEquals("Total is not correct", 90, result); // assertsame
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void shouldThrowErrorForNegativeMarks() {
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("Marks can not be negative");
		StudentMarks s1 = new StudentMarks("Sam", -15, 25, 50);

	}

	@Test
	public void resultShouldBePositive() {

	}

	@Test(expected = InvalidNameException.class)
	public void testNameValidity() {
		StudentMarks s2 = new StudentMarks("", 25, 31, 14);
		s2.setName("");
	}

	@Test
	public void testArrayOutOfBound() {
		String[] arr1 = { "abc", "rfg", "lko" };
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		thrown.expectMessage("4");
		thrown.reportMissingExceptionWithMessage("ArrayIndexOutOfBoundsException expected");
		StudentMarks s1 = new StudentMarks("Sam", 25, 31, 14);
		s1.setName(arr1[4]);

	}

}
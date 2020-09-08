package myfirstapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StudentMarksTest {

	@Test
	public void testValidityMarks() {
		StudentMarks s1 = new StudentMarks();
		s1.setDetails("Sam", 15, 25, 50);
		int result = s1.getTotal();
		assertTrue("result can not be negative", result > 0);
		assertEquals("wrong value", 90, result); // assertsame
	}

	@Test(expected = InvalidNameException.class)
	public void testNameValidity() {
		StudentMarks s2 = new StudentMarks();
		s2.setName("");
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testArrayOutOfBound() {
		String[] arr1 = { "abc", "rfg", "lko" };
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		thrown.expectMessage("4");
		thrown.reportMissingExceptionWithMessage("ArrayIndexOutOfBoundsException expected");
		StudentMarks s1 = new StudentMarks();
		s1.setName(arr1[4]);

	}

}
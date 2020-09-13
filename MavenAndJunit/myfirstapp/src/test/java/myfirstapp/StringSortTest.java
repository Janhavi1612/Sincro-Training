package myfirstapp;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StringSortTest {

	// add case-sensitive and null,
	StringSort test = new StringSort();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testNullStrigsInput() {
		String[] arrInput = { "bat", null, "elephant", "dog", "car" };
		thrown.expect(NullPointerException.class);
		test.sortStrings(arrInput);
	}

	@Test
	public void shouldSortUppercaseStrings() {
		String[] arrInput = { "bAt", "apple", "ElepHant", "dog", "car" };
		String[] expectedOutput = { "apple", "bat", "car", "dog", "elephant" };
		String[] result = test.sortStrings(arrInput);
		assertArrayEquals(expectedOutput, result);
	}

	@Test
	public void testStringSort() {
		String[] arrInput = { "bat", "apple", "elephant", "dog", "car" };
		String[] expectedOutput = { "apple", "bat", "car", "dog", "elephant" };
		String[] result = test.sortStrings(arrInput);
		assertArrayEquals(expectedOutput, result);
	}

}

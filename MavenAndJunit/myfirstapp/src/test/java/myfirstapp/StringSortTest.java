package myfirstapp;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class StringSortTest {

	@Test
	public void testStringSort() {
		Junit test = new Junit();
		String[] arrInput = { "bat", "apple", "elephant", "dog", "car" };
		String[] expectedOutput = { "apple", "bat", "car", "dog", "elephant" };
		String[] result = test.sortStrings(arrInput);
		assertArrayEquals(expectedOutput, result);
	}

}

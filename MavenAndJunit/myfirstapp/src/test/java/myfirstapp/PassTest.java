package myfirstapp;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PassTest {

	private StudentMarks student;
	private Integer inputTotal;
	private Boolean result;

	public PassTest(Integer inputTotal, Boolean result) {
		this.inputTotal = inputTotal;
		this.result = result;
	}

	@Parameterized.Parameters
	public static Collection studentResults() {
		return Arrays.asList(new Object[][] { { 38, true }, { 15, false }, { 75, true }, { 20, false }, { 67, true } });
	}

	@Test
	public void testIfPass() {
		StudentMarks s1 = new StudentMarks();
		System.out.println("Inout total is: " + inputTotal);
		assertEquals(result, s1.checkIfPass(inputTotal));

	}

}
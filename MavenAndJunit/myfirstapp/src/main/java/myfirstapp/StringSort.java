package myfirstapp;

import java.util.Arrays;

public class StringSort {
	public String[] sortStrings(String[] arrInput) {
		for (int i = 0; i < arrInput.length; i++) {
			arrInput[i] = arrInput[i].toLowerCase();
			// System.out.print(arrInput[i] + " ");
		}

		Arrays.sort(arrInput);
		return arrInput;

	}
}

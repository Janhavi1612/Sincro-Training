package com.sincro.practice.util;

import java.util.List;

public class GreeterUtil implements GreeterInterface<String> {

	private static final String EXCLAMATION = "!";
	private static final String SPACE = " ";
	private static final String AND = "AND";
	private static final String HELLO = "HELLO";
	private static final String AND_NORMAL = "and";
	private static final String FULLSTOP = ".";
	private static final String COMMA = ",";
	private static final String HELLO_NORMAL = "Hello";

	public boolean isUpperCase(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isUpperCase(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public String greetShouting(List<String> shoutStrings) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < shoutStrings.size(); i++) {
			builder.append(SPACE).append(AND).append(SPACE).append(HELLO).append(SPACE).append(shoutStrings.get(i))
					.append(EXCLAMATION);
		}
		return builder.toString();
	}

	public String greetNormal(List<String> normalStrings) {
		int inputSize = normalStrings.size();
		StringBuilder builder = new StringBuilder();
		if (inputSize == 2) {
			builder.append(normalStrings.get(0)).append(SPACE).append(AND_NORMAL).append(SPACE)
					.append(normalStrings.get(1)).append(FULLSTOP);

		} else {

			for (int i = 0; i < inputSize; i++) {
				if (i + 1 == inputSize) {
					builder.append(AND_NORMAL).append(SPACE).append(normalStrings.get(i)).append(FULLSTOP);
				} else {
					builder.append(normalStrings.get(i)).append(COMMA).append(SPACE);
				}
			}

		}
		return builder.toString();
	}

}

package com.sincro.practice.util;

import java.util.List;

public class GreeterUtil {

	private static final String EXCLAMATION = "!";
	private static final String SPACE = " ";
	private static final String AND = "AND";
	private static final String HELLO = "HELLO";
	private static final String AND_NORMAL = "and";
	private static final String FULLSTOP = ".";
	private static final String COMMA = ",";

	public boolean isUpperCase(String string) {
		return string.chars().allMatch(Character::isUpperCase);

	}

	public String greetShouting(List<String> shoutStrings) {
		StringBuilder builder = new StringBuilder();
		shoutStrings.forEach(str -> builder.append(SPACE).append(AND).append(SPACE).append(HELLO).append(SPACE)
				.append(str).append(EXCLAMATION));
		return builder.toString();
	}

	public String greetNormal(List<String> normalStrings) {
		int inputSize = normalStrings.size();
		StringBuilder builder = new StringBuilder();
		if (inputSize == 2) {
			builder.append(normalStrings.get(0)).append(SPACE).append(AND_NORMAL).append(SPACE)
					.append(normalStrings.get(1)).append(FULLSTOP);
		} else {

			normalStrings.stream().limit(inputSize - 1).forEach(str -> builder.append(str).append(COMMA).append(SPACE));
			builder.append(AND_NORMAL).append(SPACE).append(normalStrings.get(inputSize - 1)).append(FULLSTOP);

		}
		return builder.toString();
	}

}

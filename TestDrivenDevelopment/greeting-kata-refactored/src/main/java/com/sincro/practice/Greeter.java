package com.sincro.practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.sincro.practice.util.GreeterUtil;

public class Greeter {
	private static final String EXCLAMATION = "!";
	private static final String HELLO_MY_FRIEND = "Hello, my friend";
	private static final String HELLO = "HELLO";
	private static final String HELLO_NORMAL = "Hello";
	private static final String SPACE = " ";
	private static final String COMMA = ",";
	GreeterUtil greeterUtil;

	Greeter() {
		greeterUtil = new GreeterUtil();
	}

	public String greet(String string) {
		StringBuilder builder = new StringBuilder();
		if (string == null || string.isEmpty()) {
			return HELLO_MY_FRIEND;
		}
		if (greeterUtil.isUpperCase(string)) {
			builder.append(HELLO).append(SPACE).append(string).append(EXCLAMATION);
			return builder.toString();
		}
		builder.append(HELLO_NORMAL).append(COMMA).append(SPACE).append(string);
		return builder.toString();
	}

	public String greet(String[] strings) {
		Predicate<String> predicate = str -> greeterUtil.isUpperCase(str);

		List<String> shoutStrings = Arrays.stream(strings).filter(predicate).collect(Collectors.toList());

		List<String> normalStrings = Arrays.stream(strings).filter(predicate.negate())
				.map(str -> str.contains("\"") ? Arrays.asList(str) : Arrays.asList(str.split(",")))
				.flatMap(List::stream).map(str -> str.trim()).map(str -> str.replace("\"", ""))
				.collect(Collectors.toList());

		StringBuilder builder = new StringBuilder();
		builder.append(HELLO_NORMAL).append(COMMA).append(SPACE);

		builder.append(greeterUtil.greetNormal(normalStrings)).append(greeterUtil.greetShouting(shoutStrings));
		return builder.toString();

	}

}

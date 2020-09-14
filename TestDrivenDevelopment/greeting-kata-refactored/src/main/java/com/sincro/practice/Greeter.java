package com.sincro.practice;

import java.util.ArrayList;
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
		if (string.equals(null) || string.isEmpty()) {
			return HELLO_MY_FRIEND;
		}
		if (greeterUtil.isUpperCase(string)) {
			builder.append(HELLO).append(SPACE).append(string).append(EXCLAMATION);
			return builder.toString();
		}
		builder.append(HELLO_NORMAL).append(COMMA).append(SPACE).append(string);
		System.out.println(builder);
		return builder.toString();
	}

	public String greet(String[] strings) {
		List<String> normalStrings = new ArrayList<String>();
		Predicate<String> predicate = str -> greeterUtil.isUpperCase(str);

		List<String> shoutStrings = Arrays.stream(strings).filter(predicate).collect(Collectors.toList());
		List<String> normalStrings2 = Arrays.stream(strings).filter(predicate.negate()).map(str -> str.split(","))
				.flatMap(Arrays::stream).collect(Collectors.toList());

		int length = strings.length;
		for (int i = 0; i < strings.length; i++) {

			if (strings[i].contains(",")) {
				String[] split = strings[i].split(", ");
				if (strings[i].contains("\"")) {
					normalStrings.add(strings[i].substring(1, strings[i].length() - 1));
				} else {
					normalStrings.addAll(Arrays.asList(split));
				}
				length = split.length - 1;
			} else {
				normalStrings.add(strings[i]);
			}

		}
		StringBuilder builder = new StringBuilder();
		builder.append(HELLO_NORMAL);
		if (length == 2) {
			builder.append(SPACE);
		} else {
			builder.append(COMMA).append(SPACE);
		}
		builder.append(greeterUtil.greetNormal(normalStrings)).append(greeterUtil.greetShouting(shoutStrings));
		System.out.println(builder);
		return builder.toString();

	}

}

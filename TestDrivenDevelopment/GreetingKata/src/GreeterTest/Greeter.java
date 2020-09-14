package GreeterTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Greeter {
	GreeterUtil greeterUtil;

	Greeter() {
		greeterUtil = new GreeterUtil();
	}

	public String greet(String string) {
		StringBuilder builder = new StringBuilder();
		if (string.equals("")) {
			string = "my friend";
			builder.append("my friend");
		}
		if (greeterUtil.isUpperCase(string)) {
			builder.append("HELLO " + string + "!");
			return "HELLO " + string + "!";
		}
		builder.append("Hello, " + string);
		System.out.println(builder);
		return "Hello, " + string;
	}

	public String greet(String[] strings) {
		ArrayList<String> normalStrings = new ArrayList<String>();
		ArrayList<String> shoutStrings = new ArrayList<String>();
		int length = strings.length;
		for (int i = 0; i < strings.length; i++) {
			if (greeterUtil.isUpperCase(strings[i])) {
				shoutStrings.add(strings[i]);
			} else {
				if (strings[i].contains(",")) {
					String[] split = strings[i].split(", ");
					if (strings[i].contains("\"")) {
						normalStrings.add(strings[i].substring(1, strings[i].length() - 1));
					} else {

						// System.out.print(split[0] + "" + split[1] + "");
						normalStrings.addAll(Arrays.asList(split));
					}
					length = split.length - 1;
				} else {
					normalStrings.add(strings[i]);
				}
			}
		}
		StringBuilder builder = new StringBuilder();
		String hello = "Hello";
		builder.append("Hello");
		if (length == 2) {
			builder.append(" ");
			hello = hello + " ";
		} else {
			builder.append(", ");
			hello = hello + ", ";
		}
		builder.append(greeterUtil.greetNormal(normalStrings) + greeterUtil.greetShouting(shoutStrings));
		System.out.println(builder);
		return hello + greeterUtil.greetNormal(normalStrings) + greeterUtil.greetShouting(shoutStrings);

	}

}

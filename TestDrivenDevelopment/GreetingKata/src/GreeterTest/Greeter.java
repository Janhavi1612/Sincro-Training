package GreeterTest;

import java.util.ArrayList;
import java.util.Arrays;

public class Greeter {
	GreeterUtil greeterUtil;

	Greeter() {
		greeterUtil = new GreeterUtil();
	}

	public String greet(String string) {
		if (string.equals("")) {
			string = "my friend";
		}
		if (greeterUtil.isUpperCase(string)) {
			return "HELLO " + string + "!";
		}
		return "Hello, " + string;
	}

	// add in StringUtil class
	/*
	 * private static boolean isUpperCase(String string) { for (int i = 0; i <
	 * string.length(); i++) { if (!Character.isUpperCase(string.charAt(i))) {
	 * return false; } } return true; }
	 */

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
		String hello = "Hello";
		if (length == 2) {
			hello = hello + " ";
		} else {
			hello = hello + ", ";
		}
		return hello + greeterUtil.greetNormal(normalStrings) + greeterUtil.greetShouting(shoutStrings);

	}

	// use interface
	// check strings in java8
	/*
	 * private String greetShouting(ArrayList<String> shoutStrings) { String output
	 * = ""; for (int i = 0; i < shoutStrings.size(); i++) { output = output +
	 * " AND HELLO " + shoutStrings.get(i) + "!"; } return output; }
	 * 
	 * private String greetNormal(ArrayList<String> normalStrings) { int inputSize =
	 * normalStrings.size(); if (inputSize == 2) { return normalStrings.get(0) +
	 * " and " + normalStrings.get(1) + "."; } else { String output = ""; for (int i
	 * = 0; i < inputSize; i++) { if (i + 1 == inputSize) { output = output + "and "
	 * + normalStrings.get(i) + "."; } else { output = output + normalStrings.get(i)
	 * + ", "; } } return output; } }
	 */

}

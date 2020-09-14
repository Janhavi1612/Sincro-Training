package GreeterTest;

import java.util.ArrayList;

public class GreeterUtil implements GreeterUtilInterface<String> {

	@Override
	public boolean isUpperCase(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isUpperCase(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String greetShouting(ArrayList<String> shoutStrings) {
		StringBuilder builder = new StringBuilder();
		String output = "";
		for (int i = 0; i < shoutStrings.size(); i++) {
			builder.append(" AND HELLO " + shoutStrings.get(i) + "!");
			output = output + " AND HELLO " + shoutStrings.get(i) + "!";
		}
		// System.out.println(builder);
		return output;
	}

	@Override
	public String greetNormal(ArrayList<String> normalStrings) {
		int inputSize = normalStrings.size();
		StringBuilder builder = new StringBuilder();
		if (inputSize == 2) {
			builder.append(normalStrings.get(0) + " and " + normalStrings.get(1) + ".");
			// System.out.println(builder);
			return normalStrings.get(0) + " and " + normalStrings.get(1) + ".";
		} else {
			String output = "";
			for (int i = 0; i < inputSize; i++) {
				if (i + 1 == inputSize) {
					builder.append("and " + normalStrings.get(i) + ".");
					output = output + "and " + normalStrings.get(i) + ".";
				} else {
					builder.append(normalStrings.get(i) + ", ");
					output = output + normalStrings.get(i) + ", ";
				}
			}
			// System.out.println(builder);
			return output;
		}
	}

}

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
		String output = "";
		for (int i = 0; i < shoutStrings.size(); i++) {
			output = output + " AND HELLO " + shoutStrings.get(i) + "!";
		}
		return output;
	}

	@Override
	public String greetNormal(ArrayList<String> normalStrings) {
		int inputSize = normalStrings.size();
		if (inputSize == 2) {
			return normalStrings.get(0) + " and " + normalStrings.get(1) + ".";
		} else {
			String output = "";
			for (int i = 0; i < inputSize; i++) {
				if (i + 1 == inputSize) {
					output = output + "and " + normalStrings.get(i) + ".";
				} else {
					output = output + normalStrings.get(i) + ", ";
				}
			}
			return output;
		}
	}

}

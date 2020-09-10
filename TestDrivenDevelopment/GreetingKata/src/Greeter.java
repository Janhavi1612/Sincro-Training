import java.util.ArrayList;
import java.util.Arrays;

public class Greeter {

	public String greet(String string) {
		if (string.equals("")) {
			string = "my friend";
		}
		if (isUpperCase(string)) {
			return "HELLO " + string + "!";
		}
		return "Hello, " + string;
	}

	public static boolean isUpperCase(String string) {
		for (int i = 0; i < string.length(); i++) {
			if (!Character.isUpperCase(string.charAt(i))) {
				return false;
			}
		}
		return true;
	}

	public String greet(String[] strings) {
		ArrayList<String> normalStrings = new ArrayList<String>();
		ArrayList<String> shoutStrings = new ArrayList<String>();
		int length = strings.length;
		for (int i = 0; i < strings.length; i++) {
			if (isUpperCase(strings[i])) {
				shoutStrings.add(strings[i]);
			} else {
				if (strings[i].contains(",")) {
					String[] split = strings[i].split(", ");
					// System.out.print(split[0] + "" + split[1] + "");
					normalStrings.addAll(Arrays.asList(split));
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
		return hello + greetNormal(normalStrings) + greetShouting(shoutStrings);

		/*
		 * String outputNormal = "Hello, "; String outputShouting = ""; for (int i = 0;
		 * i < strings.length; i++) { if (strings.length == 2) { return "Hello " +
		 * strings[0] + " and " + strings[1] + "."; } else { if
		 * (!isUpperCase(strings[i])) { if (i + 1 == strings.length) { outputNormal =
		 * outputNormal + "and " + strings[i]; } else { outputNormal = outputNormal +
		 * strings[i] + ", "; } } else { outputShouting = outputShouting + " AND HELLO "
		 * + strings[i] + "!"; } } } return outputNormal + "." + outputShouting;
		 */
	}

	private String greetShouting(ArrayList<String> shoutStrings) {
		String output = "";
		for (int i = 0; i < shoutStrings.size(); i++) {
			output = output + " AND HELLO " + shoutStrings.get(i) + "!";
		}
		return output;
	}

	private String greetNormal(ArrayList<String> normalStrings) {
		if (normalStrings.size() == 2) {
			return normalStrings.get(0) + " and " + normalStrings.get(1) + ".";
		} else {
			String output = "";
			for (int i = 0; i < normalStrings.size(); i++) {
				if (i + 1 == normalStrings.size()) {
					output = output + "and " + normalStrings.get(i) + ".";
				} else {
					output = output + normalStrings.get(i) + ", ";
				}
			}
			return output;
		}
	}

}

package GreeterTest;

import java.util.ArrayList;

public interface GreeterUtilInterface<obj extends Object> {
	public boolean isUpperCase(String string);

	public String greetShouting(ArrayList<obj> shoutStrings);

	public String greetNormal(ArrayList<obj> normalStrings);
}

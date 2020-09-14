package com.sincro.practice.util;

import java.util.ArrayList;

public interface GreeterUtilInterface<obj> {
	public boolean isUpperCase(String string);

	public String greetShouting(ArrayList<obj> shoutStrings);

	public String greetNormal(ArrayList<obj> normalStrings);
}

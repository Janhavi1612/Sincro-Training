package com.sincro.practice.util;

import java.util.List;

public interface GreeterUtilInterface<obj> {
	public boolean isUpperCase(String string);

	public String greetShouting(List<obj> shoutStrings);

	public String greetNormal(List<obj> normalStrings);
}

package com.sincro.practice.util;

import java.util.List;

public interface GreeterInterface<T> {
	public boolean isUpperCase(String string);

	public String greetShouting(List<T> shoutStrings);

	public String greetNormal(List<T> normalStrings);
}

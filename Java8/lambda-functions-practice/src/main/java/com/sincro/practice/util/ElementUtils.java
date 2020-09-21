package com.sincro.practice.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class ElementUtils {
	public static <T> List<T> allMatches(List<T> list, Predicate<T> predicate) {
		List<T> filteredList = new ArrayList<T>();
		list.stream().forEach(t -> {
			if (predicate.test(t))
				filteredList.add(t);
		});
		return filteredList;
	}

	public static <T, Q> List<Q> transformedList(List<T> list, Function<T, Q> function) {
		List<Q> transformedList = new ArrayList<Q>();
		list.stream().forEach(t -> {
			transformedList.add((Q) function.apply(t));
		});
		return transformedList;
	}
}

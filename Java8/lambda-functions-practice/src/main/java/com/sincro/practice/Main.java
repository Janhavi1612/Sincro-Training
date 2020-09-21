package com.sincro.practice;

import java.util.Arrays;
import java.util.List;

import com.sincro.practice.util.ElementUtils;

public class Main {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("ben", "binary", "cat", "four", "five");

		List<String> shortWords = ElementUtils.allMatches(words, s -> s.length() < 4);
		System.out.println("Short Words:" + shortWords);

		List<String> wordsWithB = ElementUtils.allMatches(words, s -> s.contains("b"));
		System.out.println("Words with B:" + wordsWithB);

		List<String> evenLengthWords = ElementUtils.allMatches(words, s -> (s.length() % 2) == 0);
		System.out.println("Even length words:" + evenLengthWords);

		List<Integer> numbers = Arrays.asList(1, 10, 100, 1000);

		List<Integer> bigNums = ElementUtils.allMatches(numbers, n -> n > 50);
		System.out.println("big nums: " + bigNums);

		List<String> wordsWithExclamation = ElementUtils.transformedList(words, s -> s + "!");
		System.out.println("words With Exclamation: " + wordsWithExclamation);

		List<String> eyeWords = ElementUtils.transformedList(words, s -> s.replace("i", "eye"));
		System.out.println("eye words: " + eyeWords);

		List<String> upperCaseWords = ElementUtils.transformedList(words, String::toUpperCase);
		System.out.println("upper case words: " + upperCaseWords);

		List<Integer> wordsLengths = ElementUtils.transformedList(words, String::length);
		System.out.println("words' Lengths: " + wordsLengths);
	}
}

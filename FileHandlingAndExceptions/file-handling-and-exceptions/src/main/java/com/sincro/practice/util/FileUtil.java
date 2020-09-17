package com.sincro.practice.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileUtil {
	public void printReversedWords(String fileName) {
		checkForException(fileName, "Filename");
		try {
			Files.lines(Paths.get(fileName)).map(str -> str.split(" ")).flatMap(Arrays::stream)
					.map(str -> removeExtraChars(str)).forEach(str -> System.out.println(reverse(str)));
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}

	}

	private String reverse(String str) {
		StringBuilder builder = new StringBuilder(str);
		return builder.reverse().toString();
	}

	public boolean serachWordInFile(String fileName, String searchWord) {
		checkForException(fileName, "Filename");
		checkForException(searchWord, "Searchword");
		try {
			return Files.lines(Paths.get(fileName)).map(str -> str.split(" ")).flatMap(Arrays::stream)
					.map(str -> removeExtraChars(str)).anyMatch(str -> str.equalsIgnoreCase(searchWord));
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return false;
	}

	private void checkForException(String word, String wordType) {
		if (word == null) {
			throw new IllegalArgumentException(wordType + " can not be null");
		} else if (word.isEmpty()) {
			throw new IllegalArgumentException(wordType + " can not be empty");
		}
	}

	private String removeExtraChars(String str) {
		return str.replaceAll("[^a-zA-Z0-9]", " ");
	}

}

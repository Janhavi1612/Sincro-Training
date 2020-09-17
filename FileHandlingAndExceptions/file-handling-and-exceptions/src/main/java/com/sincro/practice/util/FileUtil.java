package com.sincro.practice.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileUtil {
	public void printReversedWords(String fileName) {
		if (fileName == null) {
			throw new IllegalArgumentException("file name can not be null");
		} else if (fileName.isEmpty()) {
			throw new IllegalArgumentException("file name can not be empty");
		} else {
			try {
				Files.lines(Paths.get(fileName)).map(str -> str.split(" ")).flatMap(Arrays::stream)
						.forEach(str -> System.out.println(reverse(str)));
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
	}

	private String reverse(String str) {
		StringBuilder builder = new StringBuilder(str);
		return builder.reverse().toString();
	}

	public boolean serachWordInFile(String fileName, String searchWord) {
		try {
			return Files.lines(Paths.get(fileName)).map(str -> str.split(" ")).flatMap(Arrays::stream)
					.map(str -> removeExtraChars(str)).anyMatch(str -> str.equals(searchWord));
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return false;
	}

	private String removeExtraChars(String str) {
		return str.replaceAll("[^a-zA-Z0-9]", " ");
	}

}

package com.sincro.practice;

import java.io.IOException;

import com.sincro.practice.util.FileUtil;

public class Main {
	public static void main(String[] args) throws IOException {
		String fileName = "sampleFile.txt";
		FileUtil fileUtil = new FileUtil();
		System.out.println("Reversed words from : " + fileName);
		fileUtil.printReversedWords(fileName);

		String searchWord = "web";
		if (fileUtil.serachWordInFile(fileName, searchWord)) {
			System.out.println("Searchword:" + searchWord + " is present in: " + fileName);
		} else {
			System.out.println("Searchword:" + searchWord + " is not present in: " + fileName);
		}
	}
}

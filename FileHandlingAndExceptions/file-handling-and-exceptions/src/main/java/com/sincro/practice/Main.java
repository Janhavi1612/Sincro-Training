package com.sincro.practice;

import com.sincro.practice.util.FileUtil;

public class Main {
	public static void main(String[] args) {
		String fileName = "sampleFile.txt";
		FileUtil fileUtil = new FileUtil();

		String searchWord = "web";
		fileUtil.printReversedWords(fileName);

		System.out.print(fileUtil.serachWordInFile(fileName, searchWord));
	}
}

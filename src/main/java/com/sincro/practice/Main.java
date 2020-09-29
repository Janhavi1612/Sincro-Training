package com.sincro.practice;

import com.sincro.practice.util.FileUtil;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "sampleFile.txt";
        FileUtil fileUtil = new FileUtil();
        System.out.println("Reversed words from : " + fileName);
        fileUtil.reverseWords("test");

        System.out.println("Reversed words from : " + fileName);
        fileUtil.reverseWords(fileName);

        String searchWord = "web";
        fileUtil.searchWordInFile(fileName, searchWord);
    }
}

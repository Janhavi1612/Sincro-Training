package com.sincro.practice.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import static java.nio.file.Files.*;


public class FileUtil {
    private static String FILE_NAME = "fileOperationslog.txt";
    StringBuilder messageToBePrinted;
    Path fileOperationsLogPath;

    public FileUtil() throws IOException {
        fileOperationsLogPath = Paths.get(FILE_NAME);
        if(!Files.exists(fileOperationsLogPath)) {
            createFile(fileOperationsLogPath);
        }

        messageToBePrinted = new StringBuilder("\n\nFile operations on : ").append(Date.from(Instant.now())).append("\n");
    }

    public void printReversedWords(String fileName) throws IOException {
        messageToBePrinted.append ("printReversedWordsMethod called on file: ").append(fileName).append("\n");
        checkIfWordIsValid(fileName, "Filename");
        messageToBePrinted.append ("printReversedWordsMethod called on file: ").append(fileName).append("\n");
        try {
            lines(Paths.get(fileName)).map(str -> str.split(" ")).flatMap(Arrays::stream)
                    .map(str -> removeExtraChars(str)).forEach(str -> messageToBePrinted.append(reverse(str)).append("\n"));
            messageToBePrinted.append("operation completed successfully.\n\n");


        } catch (IOException ioException) {
            messageToBePrinted.append("File not found. Please ensure that the file path is correct.\n\n");
        }
        write(fileOperationsLogPath, messageToBePrinted.toString().getBytes(), StandardOpenOption.APPEND);
    }


    public boolean serachWordInFile(String fileName, String searchWord) throws IOException {

        checkIfWordIsValid(fileName, "Filename");
        checkIfWordIsValid(searchWord, "Searchword");
        messageToBePrinted.append ("searchWordInFile method called on file: ").append(fileName).append(" for word: ").append(searchWord).append(".\n");
        try {
            if(lines(Paths.get(fileName)).map(str -> str.split(" ")).flatMap(Arrays::stream)
                    .map(str -> removeExtraChars(str)).anyMatch(str -> str.equalsIgnoreCase(searchWord))){
                messageToBePrinted.append("Word: ").append(searchWord).append(" found in file: ").append(fileName).append(".\n");
                messageToBePrinted.append("operation completed successfully.\n\n");
                write(fileOperationsLogPath, messageToBePrinted.toString().getBytes(), StandardOpenOption.APPEND);
                return true;
            }
            else {
                messageToBePrinted.append("Word: ").append(searchWord).append(" not found in file: ").append(fileName).append(".\n\n");
                write(fileOperationsLogPath, messageToBePrinted.toString().getBytes(), StandardOpenOption.APPEND);
                return false;
            }
        } catch (IOException ioException) {
           messageToBePrinted.append("File not found. Please ensure that the file path is correct.\n\n");
        }
        write(fileOperationsLogPath, messageToBePrinted.toString().getBytes(), StandardOpenOption.APPEND);
        return false;
    }

    private String reverse(String str) {
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }


    private void checkIfWordIsValid(String word, String wordType) {
        if (word == null) {
            messageToBePrinted.append(wordType).append(" is null. Illegal argument exception thrown.\n\n");
            throw new IllegalArgumentException(wordType + " can not be null");
        } else if (word.isEmpty()) {
            messageToBePrinted.append(wordType).append(" is empty. Illegal argument exception thrown.\n\n");
            throw new IllegalArgumentException(wordType + " can not be empty");
        }
    }

    private String removeExtraChars(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", " ");
    }
}

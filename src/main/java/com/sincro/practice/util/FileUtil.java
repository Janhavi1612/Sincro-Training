package com.sincro.practice.util;

import java.io.IOException;
import java.nio.file.*;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

import static java.nio.file.Files.*;


public class FileUtil {
    private static String FILE_NAME = "fileOperationslog.txt";
    private static StringBuilder logEntry;
    private Path fileOperationsLogPath;

    public FileUtil() throws IOException {
        fileOperationsLogPath = Paths.get(FILE_NAME);
        if(!Files.exists(fileOperationsLogPath))
        {
            createFile(fileOperationsLogPath);
        }
        logEntry = new StringBuilder("\n\nFile operations on : ").append(Date.from(Instant.now())).append("\n");
    }


    public void reverseWords(String fileName){
        logEntry.append ("printReversedWordsMethod called on file: ").append(fileName).append("\n");
        checkIfWordIsValid(fileName, "Filename");
        appendReversedWordsToLogEntry(fileName);
        logEntry.append("Reverse words operation completed successfully.\n\n");
        writeLogEntryToLogFile();
    }


    private void checkIfWordIsValid(String word, String wordType) {
        if (word == null) {
            logEntry.append(wordType).append(" is null. Illegal argument exception thrown.\n\n");
            throw new IllegalArgumentException(wordType + " can not be null");
        } else if (word.isEmpty()) {
            logEntry.append(wordType).append(" is empty. Illegal argument exception thrown.\n\n");
            throw new IllegalArgumentException(wordType + " can not be empty");
        }
    }

    private void appendReversedWordsToLogEntry(String fileName) {
        try {
            lines(Paths.get(fileName))
                    .map(str -> str.split(" "))
                    .flatMap(Arrays::stream)
                    .map(this::removeExtraChars)
                    .forEach(str -> logEntry.append(reverse(str)).append("\n"));
        } catch (IOException e) {
            logEntry.append("Error in reading the sample text file. Reverse words operation could not be completed.\n\n");
        }
    }

    private void writeLogEntryToLogFile() {
        try {
            write(fileOperationsLogPath, logEntry.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            appendErrorMessageToLogEntry();
        }
    }

    private void appendErrorMessageToLogEntry() {
        logEntry.append("Sample text file not found. Please ensure that the file path is correct.\n\n");
    }


    public boolean searchWordInFile(String fileName, String searchWord){
        logEntry.append ("searchWordInFile method called on file: ").append(fileName).append(" for word: ").append(searchWord).append(".\n");
        checkIfWordIsValid(fileName, "Filename");
        checkIfWordIsValid(searchWord, "Searchword");
        searchWordAndCreateLogEntry(fileName, searchWord);
        writeLogEntryToLogFile();
        return wordIsPresentInFile(fileName, searchWord);
    }

    private void searchWordAndCreateLogEntry(String fileName, String searchWord) {
        if(wordIsPresentInFile(fileName, searchWord))
        {
            appendWordFoundMessageToLogEntry(fileName, searchWord);
        }
        else
        {
            appendWordNotFoundMessageToLogEntry(fileName, searchWord);
        }
    }

    private boolean wordIsPresentInFile(String fileName, String searchWord){
        try {
            return lines(Paths.get(fileName))
                    .map(str -> str.split(" "))
                    .flatMap(Arrays::stream)
                    .map(this::removeExtraChars)
                    .anyMatch(str -> str.equalsIgnoreCase(searchWord));
        } catch (IOException e) {
            appendErrorMessageToLogEntry();
        }
        return false;
    }

    private void appendWordNotFoundMessageToLogEntry(String fileName, String searchWord) {
        logEntry.append("Word: ").append(searchWord).append(" not found in file: ").append(fileName).append(".\n\n");
    }

    private void appendWordFoundMessageToLogEntry(String fileName, String searchWord) {
        logEntry.append("Word: ").append(searchWord).append(" found in file: ").append(fileName).append("\nSearch word operation completed successfully.\n\n");
    }



    private String reverse(String str) {
        StringBuilder builder = new StringBuilder(str);
        return builder.reverse().toString();
    }


    private String removeExtraChars(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", " ");
    }
}

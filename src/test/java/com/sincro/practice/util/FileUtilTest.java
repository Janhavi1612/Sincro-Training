package com.sincro.practice.util;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {
    private static FileUtil fileUtil;

    @BeforeAll
    static void setUp() throws IOException {
        fileUtil = new FileUtil();
    }



    @Test
    void shouldThrowErrorForEmptyFilename() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> fileUtil.printReversedWords(""));
        assertEquals("Filename can not be empty", thrown.getMessage());
        Exception thrown2 = assertThrows(IllegalArgumentException.class, () -> fileUtil.serachWordInFile("", "web"));
        assertEquals("Filename can not be empty", thrown2.getMessage());
    }

    @Test
    void shouldThrowErrorForNullFilename() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> fileUtil.printReversedWords(null));
        assertEquals("Filename can not be null", thrown.getMessage());
        Exception thrown2 = assertThrows(IllegalArgumentException.class, () -> fileUtil.serachWordInFile(null, "web"));
        assertEquals("Filename can not be null", thrown2.getMessage());
    }

    @Test
    void shouldThrowErrorForInvalidSearchWord() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> fileUtil.serachWordInFile("test", ""));
        assertEquals("Searchword can not be empty", thrown.getMessage());
        Exception thrown2 = assertThrows(IllegalArgumentException.class, () -> fileUtil.serachWordInFile("test", null));
        assertEquals("Searchword can not be null", thrown2.getMessage());
    }

    @Test
    void testSearchWord() throws IOException {
        assertTrue(fileUtil.serachWordInFile("sampleFile.txt", "web"));
        assertFalse(fileUtil.serachWordInFile("sampleFile.txt", "eclipse"));
    }

    @Test
    void shouldSearchWordIrrespectiveOfCase() throws IOException {
        assertTrue(fileUtil.serachWordInFile("sampleFile.txt", "WeB"));
    }

}
package com.sincro.practice.util;

import org.junit.jupiter.api.*;

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
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> fileUtil.reverseWords(""));
        assertEquals("Filename can not be empty", thrown.getMessage());
        Exception thrown2 = assertThrows(IllegalArgumentException.class, () -> fileUtil.searchWordInFile("", "web"));
        assertEquals("Filename can not be empty", thrown2.getMessage());
    }

    @Test
    void shouldThrowErrorForNullFilename() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> fileUtil.reverseWords(null));
        assertEquals("Filename can not be null", thrown.getMessage());
        Exception thrown2 = assertThrows(IllegalArgumentException.class, () -> fileUtil.searchWordInFile(null, "web"));
        assertEquals("Filename can not be null", thrown2.getMessage());
    }

    @Test
    void shouldThrowErrorForInvalidSearchWord() {
        Exception thrown = assertThrows(IllegalArgumentException.class, () -> fileUtil.searchWordInFile("test", ""));
        assertEquals("Searchword can not be empty", thrown.getMessage());
        Exception thrown2 = assertThrows(IllegalArgumentException.class, () -> fileUtil.searchWordInFile("test", null));
        assertEquals("Searchword can not be null", thrown2.getMessage());
    }

    @Test
    void testSearchWord(){
        assertTrue(fileUtil.searchWordInFile("sampleFile.txt", "web"));
        assertFalse(fileUtil.searchWordInFile("sampleFile.txt", "eclipse"));
    }

    @Test
    void shouldSearchWordIrrespectiveOfCase() {
        assertTrue(fileUtil.searchWordInFile("sampleFile.txt", "WeB"));
    }

}
package com.sincro.practice.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileUtilTest {

	FileUtil fileUtil;

	@BeforeEach
	void setUp() {
		fileUtil = new FileUtil();
	}

	@Test
	void shouldThrowErrorForEmptyFilename() {
		Exception thrown = assertThrows(IllegalArgumentException.class, () -> fileUtil.printReversedWords(""));
		assertEquals("file name can not be empty", thrown.getMessage());
	}

	@Test
	void shouldThrowErrorForNullFilename() {
		Exception thrown = assertThrows(IllegalArgumentException.class, () -> fileUtil.printReversedWords(null));
		assertEquals("file name can not be null", thrown.getMessage());
	}

	@Test
	void testSearchWord() {
		assertEquals(true, fileUtil.serachWordInFile("sampleFile.txt", "web"));
		assertEquals(false, fileUtil.serachWordInFile("sampleFile.txt", "eclipse"));
	}

}

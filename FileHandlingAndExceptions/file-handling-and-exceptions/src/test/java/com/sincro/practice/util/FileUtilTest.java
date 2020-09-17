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
	void testSearchWord() {
		assertEquals(true, fileUtil.serachWordInFile("sampleFile.txt", "web"));
		assertEquals(false, fileUtil.serachWordInFile("sampleFile.txt", "eclipse"));
	}

	@Test
	void shouldSearchWordIrrespectiveOfCase() {
		assertEquals(true, fileUtil.serachWordInFile("sampleFile.txt", "WeB"));
	}

}

package com.shotkin.david;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingFormatArgumentException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DictionaryTest {

	String dictonaryFile = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\com\\shotkin\\david\\dictionary.txt";

	@Test
	public void nullFile() {
		Assert.assertFalse(Dictionary.doesFileExist(null));
	}

	@Test
	public void emptyFile() {
		Assert.assertFalse(Dictionary.doesFileExist(""));
	}

	@Test
	public void nonExistentFile() {
		String file = System.getProperty("user.dir") + "\\src\\test\\resources\\com\\shotkin\\david\\abc.txt";
		Assert.assertFalse(Dictionary.doesFileExist(file));
	}

	@Test
	public void directory() {
		String file = System.getProperty("user.dir") + "\\src\\test\\resources\\com\\shotkin\\david";
		Assert.assertFalse(Dictionary.doesFileExist(file));
	}

	@Test
	public void realFile() {
		Assert.assertTrue(Dictionary.doesFileExist(dictonaryFile));
	}

	@Test
	public void dictionary() throws MissingFormatArgumentException, IOException {
		Map<String, List<String>> dictionary = Dictionary.getDictionary(dictonaryFile);
		System.out.println("\nThe file " + dictonaryFile + " contains the following dictionary data:");
		for (Entry<String, List<String>> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey());
			for (String definition : entry.getValue()) {
				System.out.println("\t" + definition.trim());
			}
		}
	}
}

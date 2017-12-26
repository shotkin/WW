package com.shotkin.david;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.MissingFormatArgumentException;

public class Dictionary {

	public static boolean doesFileExist(String path) {
		if (path == null)
			return false;
		File file = new File(path);
		return file.exists() && file.isFile();
	}

	public static Map<String, List<String>> getDictionary(String path)
			throws IOException, MissingFormatArgumentException {
		if (!doesFileExist(path))
			throw new IOException("No file exists for the path " + path + ".");
		Map<String, List<String>> dictionary = new LinkedHashMap<>();
		try (FileReader fileReader = new FileReader(path);
				BufferedReader bufferedReader = new BufferedReader(fileReader)) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				if (line.isEmpty())
					continue;
				String[] entry = line.split("-");
				if (entry.length != 2)
					throw new MissingFormatArgumentException(line);
				String[] definitionsArray = entry[1].trim().split(",");
				if (definitionsArray.length == 0)
					throw new MissingFormatArgumentException(line);
				ArrayList<String> definitions = new ArrayList<>(Arrays.asList(definitionsArray));
				dictionary.put(entry[0].trim(), definitions);
			}
		}
		return dictionary;
	}
}

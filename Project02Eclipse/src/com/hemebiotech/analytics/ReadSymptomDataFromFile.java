package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * /** Implementation of ISymptomReader that reads symptom data from a file. The
 * file path is specified at instantiation and used to load the data. Each line
 * in the file is expected to represent a symptom entry.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * Implementation of ISymptomReader that reads symptom data from a file. Each
	 * line of the file is expected to represent a symptom entry. This class is
	 * responsible for loading and providing the raw symptom data for further
	 * processing.
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Reads symptom data from the file and returns it as a list of strings. Each
	 * line in the file corresponds to a symptom entry.
	 * 
	 * @return a list containing all symptoms read from the file
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();
				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}

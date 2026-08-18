package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Implementation of ISymptomWriter that writes symptom data to a file. Each
 * symptom and its occurrence count are written on a separate line in the
 * format: "symptom : count".
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;

	/**
	 * Creates a writer that outputs symptom data to the specified file.
	 * 
	 * @param filepath the path to the output file
	 */
	public WriteSymptomDataToFile(String filepath) {
		this.filepath = filepath;
	}

	/**
	 * Writes the list of symptoms and their occurrence counts to the file.
	 * 
	 * @param symptoms a map where the key is the symptom name and the value is its number of occurrences
	 */
	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))) {
			symptoms.forEach((key, value) -> {
					try {
						writer.write(key + " : " + value);
						writer.newLine();
						System.out.println(key + " : " + value);
					} catch (IOException e) {
						e.printStackTrace();
					}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

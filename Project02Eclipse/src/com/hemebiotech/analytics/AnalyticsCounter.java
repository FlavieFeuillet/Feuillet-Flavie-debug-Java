package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Represents an ordered list of symptoms with their number of occurrences. This
 * class allows adding and counting symptoms.
 * 
 */
public class AnalyticsCounter {

	public static void main(String args[]) throws IOException {
		
		/**
		 * Specialized list ordered on the key by default
		 */
		Map<String, Integer> occurrencesCount = new TreeMap<String, Integer>();

		/**
		 * Read the file
		 */
		try (BufferedReader reader = new BufferedReader(new FileReader("Project02Eclipse/symptoms.txt"))) {
			String line = reader.readLine();

			while (line != null) {
				// Add the line if the symptom does not exist; otherwise, increment the value of
				// the symptom
				occurrencesCount.merge(line, 1, Integer::sum);
				line = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/**
		 * Write in the file
		 */
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))) {
			occurrencesCount.forEach((key, value) -> {
				try {
					writer.write(key + " : " + value);
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

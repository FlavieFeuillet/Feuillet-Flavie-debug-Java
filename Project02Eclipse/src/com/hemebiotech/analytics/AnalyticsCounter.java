package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Analyzes symptom data by reading, counting, sorting, and writing the results.
 * This class uses an ISymptomReader to retrieve symptom data and an
 * ISymptomWriter to output the processed results.
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/**
	 * Constructs an AnalyticsCounter with the given reader and writer.
	 * Automatically performs the full analysis workflow: reading symptoms, counting
	 * occurrences, sorting them, and writing the results.
	 * 
	 * @param reader the component used to read symptom data
	 * @param writer the component used to write the processed results
	 */
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

		var symptoms = countSymptoms(getSymptoms());

		writeSymptoms(sortSymptoms(symptoms));
	}

	/**
	 * Retrieves the list of symptoms from the data source.
	 * 
	 * @return a list of symptom strings
	 */
	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	/**
	 * Counts the number of occurrences for each symptom.
	 * 
	 * @param symptoms the list of symptoms
	 * @return a map where keys are symptoms and values are their occurrence counts
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> counts = new HashMap<>();
		for (String symptom : symptoms) {
			if (symptom == null || symptom.isEmpty()) {
				continue;
			}
			counts.put(symptom, counts.getOrDefault(symptom, 0) + 1);
		}
		return counts;
	}

	/**
	 * Sorts the symptoms alphabetically.
	 * 
	 * @param symptoms a map of symptoms and their counts
	 * @return a sorted map of symptoms
	 */
	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortSymptom = new TreeMap<>(symptoms);
		return sortSymptom;
	}

	/**
	 * Writes the processed symptom data using the configured writer.
	 * 
	 * @param symptoms a map of symptoms and their counts
	 */

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}

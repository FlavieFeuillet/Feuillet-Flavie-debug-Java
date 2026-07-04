package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Defines a contract for writing symptom data to an output destination.
 * Implementations of this interface are responsible for formatting and writing
 * the list of symptoms along with their occurrence counts.
 */
public interface ISymptomWriter {
	/**
	 * Writes the given symptoms and their occurrence counts.
	 * 
	 * @param symptoms a map where the key is the symptom name and the value is its
	 * number of occurrences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}

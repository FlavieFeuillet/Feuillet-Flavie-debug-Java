package com.hemebiotech.analytics;

import java.util.Map;

/**
 * Write to the output file
 */
public interface ISymptomWriter {
	/**
	 * Write to the output file the complete list of symptoms sorted in alphabetical
	 * order, along with their number of occurrences
	 */
	public void writeSymptoms(Map<String, Integer> symptoms);
}

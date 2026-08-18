package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * Main entry point of the application. This class initializes the required
 * components (reader and writer) and executes the symptom analysis workflow:
 * reading data, counting occurrences, sorting results, and writing the output
 * to a file.
 */
public class Main {

	public static void main(String[] args) {

		/**
		 * Reader instantiation
		 */
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");

		/**
		 * Writer instantiation
		 */
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

		/**
		 * AnalyticsCounter object instantiation
		 */
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		List<String> symptoms = counter.getSymptoms();
		Map<String, Integer> counts = counter.countSymptoms((List<String>) symptoms);
		Map<String, Integer> sortSymptom = counter.sortSymptoms(counts);
		counter.writeSymptoms(sortSymptom);
	}
}

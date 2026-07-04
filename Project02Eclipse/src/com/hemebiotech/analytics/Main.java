package com.hemebiotech.analytics;

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
		new AnalyticsCounter(reader, writer);
	}

}

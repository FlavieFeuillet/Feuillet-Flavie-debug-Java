package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

	public static void main(String[] args) {
		ISymptomReader reader = new ReadSymptomDataFromFile("Project02Eclipse/symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");

		new AnalyticsCounter(reader, writer);
	}

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;

		var symptoms = countSymptoms(getSymptoms());

		writeSymptoms(sortSymptoms(symptoms));
	}

	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

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

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		Map<String, Integer> sortSymptom = new TreeMap<>(symptoms);
		return sortSymptom;
	}

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
}

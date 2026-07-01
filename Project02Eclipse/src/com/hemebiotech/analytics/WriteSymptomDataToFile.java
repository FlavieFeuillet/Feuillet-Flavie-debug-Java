package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

/**
 * Simple brute force implementation
 *
 */
public class WriteSymptomDataToFile implements ISymptomWriter {
	
	private String filepath;
	
	public WriteSymptomDataToFile (String filepath) {
		this.filepath= filepath;		
	}

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
			writer.close();
		
	} catch (IOException e) {
		e.printStackTrace();
	}
		
	}

}

package notes.utils;

import au.com.bytecode.opencsv.CSVReader;
import notes.tests.AddNewNoteWithCSVdataTest;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadDataFromCSV {
	public static List<Map<String, String>> readTestData(String dataFile) {
		List<Map<String, String>> testData = new ArrayList<>();
		
		try (CSVReader csvReader = new CSVReader(new FileReader(dataFile))) {
			String[] headers = csvReader.readNext();
			
			String[] row;
			while ((row = csvReader.readNext()) != null) {
				Map<String, String> testDataItem = new HashMap<>();
				for (int i = 0; i < headers.length; i++) {
					testDataItem.put(headers[i], row[i]);
				}
				testData.add(testDataItem);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return testData;
	}
}

package com.codeinsight.trading;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
	
	public List<String> csvReader(String sourceFileAddress) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(sourceFileAddress));
		List<String> list = new ArrayList<String>();
		String employeeRow;
		
		while ((employeeRow = bufferedReader.readLine()) != null) {
			list.add(employeeRow);
		}
		bufferedReader.close();
		return list;
	}
}

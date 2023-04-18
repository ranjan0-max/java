package com.codeinsight.trading;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvModifier {
	private final String EMPTY = "";

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

	public void csvWriter(String destinationFileAddress, List<String> employeeList) throws Exception {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(destinationFileAddress, true));
		for (String employeeRow : employeeList) {
			bufferedWriter.write(employeeRow);
			bufferedWriter.newLine();
		}
		bufferedWriter.close();
	}

	public void contentDelete(String fileAddress) throws Exception {
		PrintWriter printWriter = new PrintWriter(new FileWriter(fileAddress));
		printWriter.write(EMPTY);
		printWriter.flush();
		printWriter.close();
	}
}

package com.codeinsight.trading;

import java.util.List;

public class FileUpdater {
	
	private final String STOCK = "/home/harsh/Stocks";
	private final String HOLDING = "/home/harsh/Holding";
	private final String ACCOUNT_INFO = "/home/harsh/AccountInfo";
	private final String USERFILE = "/home/harsh/UserFile";
	
	public void updateCsvFile(List<Stock> stockList, List<AccountInfo> accountList,List<Holding> holdingList, List<UserInformation> userList) throws Exception{
		InstanceToCsvConverter instanceToCsvConverter = new InstanceToCsvConverter();
		CsvModifier csvModifier = new CsvModifier();
		
		List<String> listOfStock = instanceToCsvConverter.instanceToCsvOfStock(stockList);
		List<String> listOfHolding = instanceToCsvConverter.instanceToCsvOfHolding(holdingList);
		List<String> listOfAccount = instanceToCsvConverter.instanceToCsvOfAccountInfo(accountList);
		List<String> listOfUser = instanceToCsvConverter.instanceToCsvOfUserInformation(userList);	
		csvModifier.contentDelete(STOCK);
		csvModifier.contentDelete(ACCOUNT_INFO);
		csvModifier.contentDelete(HOLDING);
		csvModifier.contentDelete(USERFILE);
		csvModifier.csvWriter(STOCK, listOfStock);
		csvModifier.csvWriter(ACCOUNT_INFO, listOfAccount);
		csvModifier.csvWriter(HOLDING, listOfHolding);
		csvModifier.csvWriter(USERFILE, listOfUser);	
	}
}

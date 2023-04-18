package com.codeinsight.trading;

import java.util.ArrayList;
import java.util.List;

public class InstanceCreatorOfList {

	private final String STOCK = "/home/harsh/Stocks";
	private final String HOLDING = "/home/harsh/Holding";
	private final String ACCOUNT_INFO = "/home/harsh/AccountInfo";
	private final String USERFILE = "/home/harsh/UserFile";
	private final Integer ZERO = 0;
	private final Integer ONE = 1;
	private final Integer TWO = 2;
	private final Integer THREE = 3;
	private final Integer FOUR = 4;

	public List<Stock> createInstanceOfStockList() throws Exception {
		CsvModifier csvModifier = new CsvModifier();
		List<Stock> stockList = new ArrayList<Stock>();

		List<String> listOfStock = csvModifier.csvReader(STOCK);
		for (String stockRow : listOfStock) {
			String[] arrayOfStockRow = stockRow.split(",");
			Stock stock = new Stock();
			stock.setName(arrayOfStockRow[ZERO]);
			stock.setShortCode(arrayOfStockRow[ONE]);
			stock.setPrice(Integer.parseInt(arrayOfStockRow[TWO]));
			stockList.add(stock);
		}
		return stockList;
	}

	public Holding createInstanceForNewEntryOfHolding(String enteredAccountId, String enterdCode,
			Integer enteredQuantity, Integer stockPrice) {
		Holding holding = new Holding();
		holding.setAccountId(enteredAccountId);
		holding.setShortCode(enterdCode);
		holding.setQuantity(enteredQuantity);
		holding.setValue(stockPrice * enteredQuantity);
		return holding;
	}

	public List<Holding> createInstanceOfHoldingList() throws Exception {
		CsvModifier csvModifier = new CsvModifier();
		List<Holding> holdingList = new ArrayList<Holding>();
		List<String> listOfHolding = csvModifier.csvReader(HOLDING);

		for (String row : listOfHolding) {
			String[] arrayOfRow = row.split(",");
			Holding holding = new Holding();
			holding.setAccountId(arrayOfRow[ZERO]);
			holding.setShortCode(arrayOfRow[ONE]);
			holding.setQuantity(Integer.parseInt(arrayOfRow[TWO]));
			holding.setValue(Integer.parseInt(arrayOfRow[THREE]));
			holdingList.add(holding);
		}
		return holdingList;
	}

	public List<AccountInfo> createInstanceOfaccountInfoList() throws Exception {
		CsvModifier csvModifier = new CsvModifier();
		List<AccountInfo> accountList = new ArrayList<AccountInfo>();

		List<String> listOfAccount = csvModifier.csvReader(ACCOUNT_INFO);
		for (String account : listOfAccount) {
			String[] arrayOfAccount = account.split(",");
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setAccountNumber(Integer.parseInt(arrayOfAccount[ZERO]));
			accountInfo.setName(arrayOfAccount[ONE]);
			accountInfo.setTotalValue(Integer.parseInt(arrayOfAccount[TWO]));
			accountList.add(accountInfo);
		}
		return accountList;
	}

	public List<UserInformation> createInstanceOfUserInformationList() throws Exception {
		CsvModifier csvModifier = new CsvModifier();
		List<UserInformation> userList = new ArrayList<UserInformation>();

		List<String> listOfUser = csvModifier.csvReader(USERFILE);
		for (String user : listOfUser) {
			String[] arrayOfUser = user.split(",");
			UserInformation userInformation = new UserInformation();
			userInformation.setName(arrayOfUser[ZERO]);
			userInformation.setCity(arrayOfUser[ONE]);
			userInformation.setCountry(arrayOfUser[TWO]);
			userInformation.setTotalCash(Integer.parseInt(arrayOfUser[THREE]));
			userInformation.setNumberOfAccount(Integer.parseInt(arrayOfUser[FOUR]));
			userList.add(userInformation);
		}
		return userList;
	}
}

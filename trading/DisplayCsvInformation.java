package com.codeinsight.trading;

import java.util.List;

public class DisplayCsvInformation {

	private final String SPACE = " ";

	public void dispalyListOfStock(List<Stock> stockList) {
		for (Stock stock : stockList) {
			String name = stock.getName();
			String shortCode = stock.getShortCode();
			Integer price = stock.getPrice();

			System.out.println(name + SPACE + shortCode + SPACE + price);
		}
	}

	public void displayListOfAccountInfo(List<AccountInfo> accountList) {
		for (AccountInfo account : accountList) {
			Integer accountNumber = account.getAccountNumber();
			String accountName = account.getName();
			Integer totalValue = account.getTotalValue();

			System.out.println(accountNumber + SPACE + accountName + SPACE + totalValue);
		}
	}

	public void displayListOfHolding(List<Holding> holdingList) {
		for (Holding holding : holdingList) {
			String accountId = holding.getAccountId();
			String shortCode = holding.getShortCode();
			Integer quantity = holding.getQuantity();
			Integer value = holding.getValue();

			System.out.println(accountId + SPACE + shortCode + SPACE + quantity + SPACE + value);
		}
	}

	public void displayListOfUser(List<UserInformation> userInfoList) {
		for (UserInformation user : userInfoList) {
			String name = user.getName();
			String city = user.getCity();
			String country = user.getCountry();
			Integer totalCash = user.getTotalCash();
			Integer numberOfAccounts = user.getNumberOfAccount();

			System.out.println(name + SPACE + city + SPACE + country + totalCash + SPACE + numberOfAccounts);
		}
	}
}

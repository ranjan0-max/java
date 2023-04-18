package com.codeinsight.trading;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StockSeller {

	private final String SPACE = " ";

	private ArrayList<String> holdingDisplay(List<Holding> holdingList, String inputShortCode) {
		System.out.println("Your Holding are for this stock are :-");
		ArrayList<String> listOfAccountName = new ArrayList<String>();

		for (Holding holding : holdingList) {
			if (holding.getShortCode().equals(inputShortCode)) {
				String accountName = holding.getAccountId();
				String shortCode = holding.getShortCode();
				Integer quantity = holding.getQuantity();
				Integer value = holding.getValue();
				listOfAccountName.add(accountName);

				System.out.println(accountName + SPACE + shortCode + SPACE + quantity + SPACE + value);
			}
		}
		return listOfAccountName;
	}

	private boolean enoughStocks(List<Holding> holdingList, String inputShortCode, Integer inputQuantity,
			String inputAccountName) {
		for (Holding holding : holdingList) {
			if (holding.getAccountId().equals(inputAccountName) && holding.getShortCode().equals(inputShortCode)) {
					if (holding.getQuantity() >= inputQuantity) {
						return true;
					}
			}
		}
		return false;
	}

	private void modifyHolding(List<Holding> holdingList, Integer inputQuantity, String inputShortCode,
			String inputAccountName) {
		for (Holding holding : holdingList) {
			if (holding.getAccountId().equals(inputAccountName)) {
				if (holding.getShortCode().equals(inputShortCode)) {
					Integer holdingQuantity = holding.getQuantity();
					Integer holdingValue = holding.getValue();
					Integer stockPrice = holdingValue / holdingQuantity;

					holding.setQuantity(holdingQuantity - inputQuantity);
					holding.setValue(holdingValue - (inputQuantity * stockPrice));
					break;
				}
			}
		}
	}

	public void sellStock(Scanner scanner, List<Stock> stockList, List<AccountInfo> accountList,
			List<Holding> holdingList, List<UserInformation> userList) throws Exception {
		DisplayCsvInformation displayCsvInformation = new DisplayCsvInformation();
		ShortCodeChecker shortCodeChecker = new ShortCodeChecker();

		System.out.println("\nList of Stock");
		displayCsvInformation.dispalyListOfStock(stockList);

		System.out.println("\nEnter the shortCode :-");
		String inputShortCode = scanner.nextLine();

		if (shortCodeChecker.checkShortCode(inputShortCode, stockList)) {
			ArrayList<String> arrayListOfAccountName = holdingDisplay(holdingList, inputShortCode);
			System.out.println("\nEnter the account name :-");
			String inputAccountName = scanner.nextLine();
			if (arrayListOfAccountName.contains(inputAccountName)) {
				System.out.println("\nEnter the quantity you want to sell :-");
				Integer inputQuantity = Integer.parseInt(scanner.nextLine());
				if (enoughStocks(holdingList, inputShortCode, inputQuantity, inputAccountName)) {
					modifyHolding(holdingList, inputQuantity, inputShortCode, inputAccountName);
				} else {
					System.out.println("\nyou don't have enough stocks");
				}

				System.out.println("\nUser Information :-");
				displayCsvInformation.displayListOfUser(userList);
				System.out.println("\nList of Stock");
				displayCsvInformation.dispalyListOfStock(stockList);
				System.out.println("\nAccount Information");
				displayCsvInformation.displayListOfAccountInfo(accountList);
				System.out.println("\nHolding Account Infomation");
				displayCsvInformation.displayListOfHolding(holdingList);
			} else {
				System.out.println("Account Not Found.... ");
			}
		} else {
			System.out.println("Enter valid Short Code.....");
		}

	}
}

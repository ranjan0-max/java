package com.codeinsight.trading;

import java.util.List;
import java.util.Scanner;

public class StockBuyer {

	private final String SPACE = " ";
	private final Integer ZERO = 0;

	private boolean enoughCash(List<AccountInfo> accountlist, List<Holding> holdingList,
			String inputAccountId, Integer quantity, Integer stockPrice) {
		Integer totalValue = ZERO;
		Integer stockValue = ZERO;

		for (AccountInfo account : accountlist) {
			if (account.getName().equals(inputAccountId)) {
				totalValue = account.getTotalValue();
				break;
			}
		}
		for (Holding holding : holdingList) {
			if (holding.getAccountId().equals(inputAccountId)) {
				stockValue += holding.getValue();
			}
		}
		Integer buyValue = quantity * stockPrice;
		Integer totalCash = totalValue - stockValue;
		if (buyValue <= totalCash) {
			return true;
		} else {
			return false;
		}
	}

	private Integer totalHoldingValue(List<Holding> holdingList, String accountName) {
		Integer totalValue = ZERO;
		for (Holding holding : holdingList) {
			if (holding.getAccountId().equals(accountName)) {
				totalValue += holding.getValue();
			}
		}
		return totalValue;
	}

	private boolean accountPresentInHolding(List<Holding> holdingList, String inputAccountId,
			String inputShortCode) {
		boolean bool = false;
		for (Holding holding : holdingList) {
			if (holding.getAccountId().equals(inputAccountId) && holding.getShortCode().equals(inputShortCode)) {
					bool = true;
					break;
			}
		}
		return bool;
	}

	private void displayStock(Stock stock) {
		String stockName = stock.getName();
		String shortCode = stock.getShortCode();
		Integer stockPrice = stock.getPrice();
		System.out.println(stockName + SPACE + shortCode + SPACE + stockPrice);
	}

	private void modifyHolding(List<Holding> holdingList, String inputAccountId, String inputShortCode,
			Integer inputQuantity, Integer stockPrice) {
		for (Holding holding : holdingList) {
			String holdingAccountId = holding.getAccountId();
			String holdingShortCode = holding.getShortCode();
			if (holdingAccountId.equals(inputAccountId) && holdingShortCode.equals(inputShortCode)) {
					Integer stockQuantity = holding.getQuantity();
					Integer holdingValue = holding.getValue();

					holding.setQuantity(stockQuantity + inputQuantity);
					holding.setValue(holdingValue + (inputQuantity * stockPrice));
			}
		}
	}

	private void displayCashOfAccount(List<AccountInfo> accountList, List<Holding> holdingList) {
		for (AccountInfo account : accountList) {
			String accountName = account.getName();
			Integer holdingValue = totalHoldingValue(holdingList, accountName);
			Integer totalCash = account.getTotalValue() - holdingValue;

			System.out.println(accountName + SPACE + totalCash);
		}
	}

	public void buyStock(Scanner scanner, List<Stock> stockList, List<AccountInfo> accountList,
			List<Holding> holdingList, List<UserInformation> userList) throws Exception {
		InstanceCreatorOfList instanceCreatorOfCsvFile = new InstanceCreatorOfList();
		DisplayCsvInformation displayCsvInformation = new DisplayCsvInformation();
		ShortCodeChecker shortCodeChecker = new ShortCodeChecker();
		System.out.println("\nList of Stock");
		displayCsvInformation.dispalyListOfStock(stockList);

		System.out.println("\nEnter the shorCode of Stock :-");
		String inputShortCode = scanner.nextLine();
		if (shortCodeChecker.checkShortCode(inputShortCode, stockList)) {
			Integer stockPrice = ZERO;

			for (Stock stock : stockList) {
				if (stock.getShortCode().equals(inputShortCode)) {
					stockPrice = stock.getPrice();
					displayStock(stock);
					break;
				}
			}
			System.out.println("\nYour Accounts Information :-");
			System.out.println("Name Cash");
			displayCashOfAccount(accountList, holdingList);

			System.out.println("\nFrom Which Account you want to buy :-");
			String inputAccountId = scanner.nextLine();
			Integer inputQuantity = ZERO;
			boolean accountFound = false;

			for (AccountInfo account : accountList) {
				String accountInfoAccountName = account.getName();
				if (accountInfoAccountName.equals(inputAccountId)) {
					accountFound = true;
					System.out.println("\nEnter the Quantity :-");
					inputQuantity = Integer.parseInt(scanner.nextLine());
					if (enoughCash(accountList, holdingList, inputAccountId, inputQuantity, stockPrice)) {
						if (accountPresentInHolding(holdingList, inputAccountId, inputShortCode)) {
							modifyHolding(holdingList, inputAccountId, inputShortCode, inputQuantity, stockPrice);
						} else {
							Holding instanceOfNewEntry = instanceCreatorOfCsvFile.createInstanceForNewEntryOfHolding(
									inputAccountId, inputShortCode, inputQuantity, stockPrice);
							holdingList.add(instanceOfNewEntry);
						}
					} else {
						System.out.println("\nyou don't have enough cash.....");
					}
				}
			}
			if (!accountFound) {
				System.out.println("\nAccount Not Found....");
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
			System.out.println("Stock not Found....");
		}
	}

}

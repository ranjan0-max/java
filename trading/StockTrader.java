package com.codeinsight.trading;

import java.util.List;
import java.util.Scanner;

public class StockTrader {

	private final Integer ONE = 1;
	private final Integer TWO = 2;
	private final Integer THREE = 3;
	private final Integer MINUS_ONE = -1;


	public void tradeStock() throws Exception {
		DisplayCsvInformation displayCsvInformation = new DisplayCsvInformation();
		InstanceCreatorOfList instanceCreatorOfList = new InstanceCreatorOfList();
		FileUpdater fileUpdater = new FileUpdater();
		Scanner scanner = new Scanner(System.in);
		StockBuyer stockBuyer = new StockBuyer();
		StockSeller stockSeller = new StockSeller();
		
		List<Stock> stockList = instanceCreatorOfList.createInstanceOfStockList();
		List<AccountInfo> accountList = instanceCreatorOfList.createInstanceOfaccountInfoList();
		List<Holding> holdingList = instanceCreatorOfList.createInstanceOfHoldingList();
		List<UserInformation> userList = instanceCreatorOfList.createInstanceOfUserInformationList();

		Integer userInput = MINUS_ONE;
		while (userInput != 0) {
			System.out.println("\npress 1 to Buy and 2 to Sell 3 to see Holdings and 0 to exit :-");
			try {
				userInput = Integer.parseInt(scanner.nextLine());				
			} catch(Exception e) {
			}
			if (userInput == ONE) {
				try {
					stockBuyer.buyStock(scanner, stockList, accountList, holdingList, userList);
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if (userInput == TWO) {
				try {
					stockSeller.sellStock(scanner, stockList, accountList, holdingList, userList);
				} catch (Exception e) {
					System.out.println(e);
				}
			} else if (userInput == 0) {
				fileUpdater.updateCsvFile(stockList, accountList, holdingList, userList);
				System.out.println("exiting....");
			} else if (userInput == THREE) {
				displayCsvInformation.displayListOfHolding(holdingList);
			} else {
				System.out.println("Invalid input try again...");
			}
		}

	}
}

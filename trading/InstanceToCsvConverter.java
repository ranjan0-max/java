package com.codeinsight.trading;

import java.util.ArrayList;
import java.util.List;

public class InstanceToCsvConverter {
	
	private final String COMA = ",";
	
	public List<String> instanceToCsvOfStock(List<Stock> stockList) {
		List<String> listOfStock = new ArrayList<String>();
		
		for(Stock stock : stockList) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(stock.getName());
			stringBuilder.append(COMA);
			stringBuilder.append(stock.getShortCode());
			stringBuilder.append(COMA);
			stringBuilder.append(stock.getPrice());
			listOfStock.add(stringBuilder.toString());
		}
		return listOfStock;
	}
	
	public List<String> instanceToCsvOfHolding(List<Holding> holdingList){
		List<String> listOfHolding = new ArrayList<String>();
		
		for(Holding holding : holdingList) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(holding.getAccountId());
			stringBuilder.append(COMA);
			stringBuilder.append(holding.getShortCode());
			stringBuilder.append(COMA);
			stringBuilder.append(holding.getQuantity());
			stringBuilder.append(COMA);
			stringBuilder.append(holding.getValue());
			listOfHolding.add(stringBuilder.toString());
		}
		return listOfHolding;
	}
	
	public List<String> instanceToCsvOfAccountInfo(List<AccountInfo> accountList){
		List<String> listOfAccount = new ArrayList<String>();
		
		for(AccountInfo account : accountList) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(account.getAccountNumber());
			stringBuilder.append(COMA);
			stringBuilder.append(account.getName());
			stringBuilder.append(COMA);
			stringBuilder.append(account.getTotalValue());
			stringBuilder.append(COMA);
			listOfAccount.add(stringBuilder.toString());
		}
		return listOfAccount;
	}
	
	public List<String> instanceToCsvOfUserInformation(List<UserInformation> userList){
		List<String> listOfUser = new ArrayList<String>();
		
		for(UserInformation user : userList) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(user.getName());
			stringBuilder.append(COMA);
			stringBuilder.append(user.getCity());
			stringBuilder.append(COMA);
			stringBuilder.append(user.getCountry());
			stringBuilder.append(COMA);
			stringBuilder.append(user.getTotalCash());
			stringBuilder.append(COMA);
			stringBuilder.append(user.getNumberOfAccount());
			listOfUser.add(stringBuilder.toString());
		}
		return listOfUser;
	}
}

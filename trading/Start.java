package com.codeinsight.trading;

public class Start {

	public static void main(String[] args) {
		StockTrader stockTrader = new StockTrader();
		try {
			stockTrader.tradeStock();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

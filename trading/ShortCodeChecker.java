package com.codeinsight.trading;

import java.util.List;

public class ShortCodeChecker {
	
	public boolean checkShortCode(String inputShortCode, List<Stock> stockList) {
		for (Stock stock : stockList) {
			if (stock.getShortCode().equals(inputShortCode)) {
				return true;
			}
		}
		return false;
	}

}

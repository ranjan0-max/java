package com.codeinsight.trading;

public class AccountInfo {

	private Integer accountNumber;
	private String name;
	private Integer totalValue;

	public Integer getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Integer number) {
		this.accountNumber = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Integer totalValue) {
		this.totalValue = totalValue;
	}

}

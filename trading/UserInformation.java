package com.codeinsight.trading;

public class UserInformation {

	private String name;
	private String city;
	private String country;
	private Integer totalCash;
	private Integer numberOfAccount;

	public Integer getNumberOfAccount() {
		return numberOfAccount;
	}

	public void setNumberOfAccount(Integer numberOfAccount) {
		this.numberOfAccount = numberOfAccount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getTotalCash() {
		return totalCash;
	}

	public void setTotalCash(Integer totalCash) {
		this.totalCash = totalCash;
	}

}
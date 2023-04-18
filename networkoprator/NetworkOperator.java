package com.codeinsight.networkoprator;

import java.util.Set;

import com.codeinsight.networkoprator.EnumOperatorName.NetworkOperatorName;

public class NetworkOperator {
	private NetworkOperatorName name;
	private String origin;
	private Long startRange;
	private Long endRange;
	private Set<Long> phoneBook;

	public NetworkOperatorName getName() {
		return name;
	}

	public void setName(NetworkOperatorName name) {
		this.name = name;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String oregin) {
		this.origin = oregin;
	}

	public Long getStartRange() {
		return startRange;
	}

	public void setStartRange(Long startRange) {
		this.startRange = startRange;
	}

	public Long getEndRange() {
		return endRange;
	}

	public void setEndRange(Long endrange) {
		this.endRange = endrange;
	}

	public Set<Long> getPhoneBook() {
		return phoneBook;
	}

	public void setPhoneBook(Set<Long> phoneBook) {
		this.phoneBook = phoneBook;
	}

}

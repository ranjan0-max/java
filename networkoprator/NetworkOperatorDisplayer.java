package com.codeinsight.networkoprator;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.codeinsight.networkoprator.EnumOperatorName.NetworkOperatorName;

public class NetworkOperatorDisplayer {

	private final String HIFAN = "-";

	public void displayPhoneBookContent(Map<NetworkOperatorName, NetworkOperator> networkOperatorMap) {

		for (Entry<NetworkOperatorName, NetworkOperator> networkOperator : networkOperatorMap.entrySet()) {

			Set<Long> phoneBook = networkOperator.getValue().getPhoneBook();
			NetworkOperatorName operatorName = networkOperator.getKey();

			System.out.println(operatorName + HIFAN + phoneBook);
		}
	}
}

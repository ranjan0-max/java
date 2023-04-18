package com.codeinsight.networkoprator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.codeinsight.networkoprator.EnumOperatorName.NetworkOperatorName;

public class NetworkOperatorCreator {

	private NetworkOperator createJioOperator() {

		Set<Long> phoneNumberList = new HashSet<Long>();
		phoneNumberList.add(8627814292L);
		phoneNumberList.add(3456276890L);
		phoneNumberList.add(9900276890L);
		phoneNumberList.add(9656276890L);
		phoneNumberList.add(9456276890L);

		NetworkOperator networkOperator = new NetworkOperator();
		networkOperator.setName(EnumOperatorName.NetworkOperatorName.JIO);
		networkOperator.setPhoneBook(phoneNumberList);
		networkOperator.setOrigin("India");
		networkOperator.setStartRange(9000000000L);
		networkOperator.setEndRange(9999999999L);
		return networkOperator;
	}

	private NetworkOperator createAirtelOperator() {

		Set<Long> phoneNumberList = new HashSet<Long>();
		phoneNumberList.add(8627814111L);
		phoneNumberList.add(3456200890L);
		phoneNumberList.add(8006200890L);
		phoneNumberList.add(8766200890L);
		phoneNumberList.add(9876200890L);

		NetworkOperator networkOperator = new NetworkOperator();
		networkOperator.setName(EnumOperatorName.NetworkOperatorName.AIRTEL);
		networkOperator.setPhoneBook(phoneNumberList);
		networkOperator.setOrigin("India");
		networkOperator.setStartRange(9000000000L);
		networkOperator.setEndRange(9999999999L);
		return networkOperator;
	}

	public Map<NetworkOperatorName, NetworkOperator> createNetworkOperator() {
		Map<NetworkOperatorName, NetworkOperator> networkOperatorMap = new HashMap<NetworkOperatorName, NetworkOperator>();

		networkOperatorMap.put(EnumOperatorName.NetworkOperatorName.JIO, createJioOperator());
		networkOperatorMap.put(EnumOperatorName.NetworkOperatorName.AIRTEL, createAirtelOperator());
		return networkOperatorMap;
	}
}

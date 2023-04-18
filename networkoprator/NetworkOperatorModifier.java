package com.codeinsight.networkoprator;

import java.util.Map;
import java.util.Scanner;

import com.codeinsight.networkoprator.EnumOperatorName.NetworkOperatorName;

public class NetworkOperatorModifier {

	public void networkOperatorModifierMethods() {

		Scanner scanner = new Scanner(System.in);
		NetworkOperatorCreator networkOperatorCreator = new NetworkOperatorCreator();
		NetworkOperatorDisplayer networkOperatorDisplayer = new NetworkOperatorDisplayer();
		NetworkOperatorAttributeModifier networkOperatorAttributeModifier = new NetworkOperatorAttributeModifier();

		Map<NetworkOperatorName, NetworkOperator> networkOperatorMap = networkOperatorCreator.createNetworkOperator();
		networkOperatorDisplayer.displayPhoneBookContent(networkOperatorMap);

		networkOperatorAttributeModifier.deletePhoneNumberFromPhoneBook(networkOperatorMap, scanner);
		networkOperatorDisplayer.displayPhoneBookContent(networkOperatorMap);

		networkOperatorAttributeModifier.addPhoneNumberIntoPhoneBook(networkOperatorMap, scanner);
		networkOperatorDisplayer.displayPhoneBookContent(networkOperatorMap);

		networkOperatorAttributeModifier.portPhoneNumberFromOneOperatorToAnother(networkOperatorMap, scanner);
		networkOperatorDisplayer.displayPhoneBookContent(networkOperatorMap);
		scanner.close();

	}
}

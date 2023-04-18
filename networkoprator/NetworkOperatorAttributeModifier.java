package com.codeinsight.networkoprator;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import com.codeinsight.networkoprator.EnumOperatorName.NetworkOperatorName;

public class NetworkOperatorAttributeModifier {

	private Long getPhoneNumberFromUserForDelete(Scanner scanner) {

		System.out.println("Enter the Phone Number you want to delete :-");
		Long phoneNumber = Long.parseLong(scanner.nextLine());
		return phoneNumber;
	}

	private NetworkOperator getUserDetailForPort(Scanner scanner) {
		NetworkOperator networkOperator = new NetworkOperator();

		System.out.println("Enter the Phone Number you want to Port :-");
		Set<Long> phoneNumber = new HashSet<Long>();
		String number = scanner.nextLine();
		Long longNumber = Long.parseLong(number);

		phoneNumber.add(longNumber);
		networkOperator.setPhoneBook(phoneNumber);

		System.out.println("Enter the Network Operator Name :-");
		String operatorName = scanner.nextLine();
		networkOperator.setName(NetworkOperatorName.valueOf(operatorName.toUpperCase()));

		return networkOperator;
	}

	private NetworkOperator getPhoneNumberFromUserForAdd(Scanner scanner) {
		NetworkOperator networkOperator = new NetworkOperator();

		System.out.println("Enter the Phone Number you want to Add :-");
		Set<Long> phoneNumber = new HashSet<Long>();
		String number = scanner.nextLine();
		Long longNumber = Long.parseLong(number);

		phoneNumber.add(longNumber);
		networkOperator.setPhoneBook(phoneNumber);

		System.out.println("Enter the Network Operator Name :-");
		String operatorName = scanner.nextLine();
		networkOperator.setName(NetworkOperatorName.valueOf(operatorName.toUpperCase()));

		return networkOperator;
	}

	public void deletePhoneNumberFromPhoneBook(Map<NetworkOperatorName, NetworkOperator> networkOperatorMap,
			Scanner longScanner) {
		Long phoneNumber = getPhoneNumberFromUserForDelete(longScanner);
		boolean numberFound = false;

		for (NetworkOperator operator : networkOperatorMap.values()) {

			Set<Long> phoneBook = operator.getPhoneBook();
			NetworkOperatorName operatorName = operator.getName();

			if (phoneBook.contains(phoneNumber)) {
				System.out.println("This number is from \"" + operatorName + "\" and number is " + phoneNumber);
				numberFound = true;
				phoneBook.remove(phoneNumber);
				break;
			}
		}
		if (!numberFound) {
			System.out.println("Number not Found");
		}
	}

	public void addPhoneNumberIntoPhoneBook(Map<NetworkOperatorName, NetworkOperator> networkOperatorMap,	Scanner scanner) {
		
		NetworkOperator networkOperator = getPhoneNumberFromUserForAdd(scanner);
		NetworkOperatorName userEnterOperatorName = networkOperator.getName();
		Set<Long> userEnterPhoneNumber = networkOperator.getPhoneBook();

		if (networkOperatorMap.containsKey(userEnterOperatorName)) {
			NetworkOperator networkOperatorName = networkOperatorMap.get(userEnterOperatorName);
			Set<Long> phoneBook = networkOperatorName.getPhoneBook();
			phoneBook.addAll(userEnterPhoneNumber);
		} else {
			System.out.println("Operator not found");
		}
	}

	public void portPhoneNumberFromOneOperatorToAnother(Map<NetworkOperatorName, NetworkOperator> networkOperatorMap, Scanner scanner) {
		
		NetworkOperator networkOperator = getUserDetailForPort(scanner);
		NetworkOperatorName userEnterOperatorName = networkOperator.getName();
		Set<Long> userEnterPhoneNumber = networkOperator.getPhoneBook();

		if (networkOperatorMap.containsKey(userEnterOperatorName)) {
			for (Entry<NetworkOperatorName, NetworkOperator> operator : networkOperatorMap.entrySet()) {

				Set<Long> phoneBook = operator.getValue().getPhoneBook();

				if (phoneBook.containsAll(userEnterPhoneNumber)) {
					phoneBook.removeAll(userEnterPhoneNumber);
					break;
				}
			}
			NetworkOperator singleNetworkOperator = networkOperatorMap.get(userEnterOperatorName);
			Set<Long> phoneBook = singleNetworkOperator.getPhoneBook();
			phoneBook.addAll(userEnterPhoneNumber);
		} else {
			System.out.println("operator not found");
		}
	}

}

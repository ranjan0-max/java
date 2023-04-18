package com.codeinsight.curdOperations;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DatabaseModifier {

	private final Integer MINUS_ONE = -1;
	private final Integer ONE = 1;
	private final Integer TWO = 2;
	private final Integer THREE = 3;
	private final Integer FOUR = 4;
	private final Integer FIVE = 5;

	private Integer choseNameOrAddress(Scanner scanner) {
		System.out.println("\nPress 1 for Name 2 for Address :-");
		Integer option = Integer.parseInt(scanner.nextLine());

		if (option == ONE) {
			return ONE;
		} else if (option == TWO) {
			return TWO;
		} else {
			System.out.println("enter the valid option ");
		}
		return THREE;
	}

	public void operationSelector(Scanner scanner, Connection connection) throws ClassNotFoundException, SQLException {
		StudentableManipulator studentableManipulator = new StudentableManipulator();
		Student student = new Student();
		List<StudentBean> listOfStudent = student.createStudent(connection);
		Integer option = MINUS_ONE;

		while (true) {
			System.out.println("Press 1 for Display 2 for Insert Row 3 for Delete Row 4 for Update 5 for exit ");
			try {
				option = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
			}

			if (option == ONE) {
				studentableManipulator.dispalyTable(connection, listOfStudent);

			} else if (option == TWO) {
				System.out.println("enter the Id of student :-");
				Integer id = Integer.parseInt(scanner.nextLine());

				System.out.println("Enter the name :-");
				String name = scanner.nextLine();

				System.out.println("Enter the address :-");
				String address = scanner.nextLine();

				studentableManipulator.insertRow(id, name, address, connection);

			} else if (option == THREE) {
				System.out.println("enter the id of Student :- ");
				Integer id = Integer.parseInt(scanner.nextLine());

				studentableManipulator.deleteRow(id, connection);

			} else if (option == FOUR) {
				System.out.println("Enter the id of Student :- ");
				Integer id = Integer.parseInt(scanner.nextLine());

				if (choseNameOrAddress(scanner) == ONE) {
					System.out.println("Enter the new Name :- ");
					String name = scanner.nextLine();

					studentableManipulator.updateNameInTable(connection, id, name);

				} else if (choseNameOrAddress(scanner) == TWO) {
					System.out.println("Enter the new Address :- ");
					String address = scanner.nextLine();

					studentableManipulator.updateAddressInTable(connection, id, address);

				} else {
					System.out.println("\nEnter valid option");
				}
			} else if (option == FIVE) {
				break;
			} else {
				System.out.println("Select valid option");
			}
		}
	}
}

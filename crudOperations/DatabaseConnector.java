package com.codeinsight.curdOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnector {

	private final String USER_NAME = "admin";
	private final String PASSWORD = "Codeinsight@123";
	private final String URL = "jdbc:mysql://localhost:3306/studentInformation";
	private final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

	private Connection connectionOfStudentInformation() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS_NAME);
		Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

		return connection;
	}

	public void databaseConnection() {
		DatabaseModifier databaseModifier = new DatabaseModifier();
		Connection connection = null;
		Scanner scanner = new Scanner(System.in);

		try {
			connection = connectionOfStudentInformation();
			databaseModifier.operationSelector(scanner, connection);

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				connection.close();
				scanner.close();
				System.out.println("connection close");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

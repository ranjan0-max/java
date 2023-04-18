package com.codeinsight.curdOperations;

import java.sql.*;
import java.util.List;

public class StudentableManipulator {

	private final String TABLE_NAME = "student";
	private final String SPACE = " ";
	private final String INSERT_QUERY = "insert into " + TABLE_NAME + " values(?,?,?)";
	private final String DELETE_QUERY = "DELETE FROM " + TABLE_NAME + " WHERE" + SPACE + "id=?";
	private final String UPDATE_ADDRESS = "UPDATE " + TABLE_NAME + " SET address=? WHERE id=?";
	private final String UPDATE_NAME = "UPDATE " + TABLE_NAME + " SET address=? WHERE id=?";
	private final Integer ONE = 1;
	private final Integer TWO = 2;
	private final Integer THREE = 3;
	private boolean rowAffected = false;

	public void insertRow(Integer id, String name, String address, Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
		statement.setInt(ONE, id);
		statement.setString(TWO, name);
		statement.setString(THREE, address);

		Integer numberOfRowAffected = statement.executeUpdate();
		rowAffected = true;
		System.out.println(numberOfRowAffected + " row inserted");
	}

	public void deleteRow(Integer id, Connection connection) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
		statement.setInt(ONE, id);

		Integer numberOfRowAffected = statement.executeUpdate();
		rowAffected = true;
		System.out.println(numberOfRowAffected + " row deleted");
	}

	private StringBuilder beanToStringBuilder(StudentBean singleStudent) {
		StringBuilder studentDetail = new StringBuilder();

		studentDetail.append(singleStudent.getId());
		studentDetail.append(SPACE);
		studentDetail.append(singleStudent.getName());
		studentDetail.append(SPACE);
		studentDetail.append(singleStudent.getAddress());

		return studentDetail;
	}

	public void dispalyTable(Connection connection, List<StudentBean> listOfStudent) throws SQLException {

		if (rowAffected) {
			Student student = new Student();
			List<StudentBean> updatedListOfStudent = student.createStudent(connection);

			for (StudentBean singleStudent : updatedListOfStudent) {
				StringBuilder studentDetail = beanToStringBuilder(singleStudent);
				System.out.println(studentDetail);
			}
		} else {
			for (StudentBean singleStudent : listOfStudent) {
				StringBuilder studentDetail = beanToStringBuilder(singleStudent);
				System.out.println(studentDetail);
			}
		}
	}

	public void updateAddressInTable(Connection connection, Integer id, String address) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(UPDATE_ADDRESS);
		statement.setString(ONE, address);
		statement.setInt(TWO, id);

		Integer numberOfRowAffected = statement.executeUpdate();
		rowAffected = true;
		System.out.println(numberOfRowAffected + " row updated");

	}
	
	public void updateNameInTable(Connection connection, Integer id, String name) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(UPDATE_NAME);
		statement.setString(ONE, name);
		statement.setInt(TWO, id);
		
		Integer numberOfRowAffected = statement.executeUpdate();
		rowAffected = true;
		System.out.println(numberOfRowAffected + " row updated");
	}
}

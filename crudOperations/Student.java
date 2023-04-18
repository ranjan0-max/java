package com.codeinsight.curdOperations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Student {

	private final String TABLE_NAME = "student";
	private final String DISPLAY_QUERY = "SELECT * FROM " + TABLE_NAME;
	private final Integer ONE = 1;
	private final Integer TWO = 2;
	private final Integer THREE = 3;

	public List<StudentBean> createStudent(Connection connection) throws SQLException {
		List<StudentBean> listOfStudent = new ArrayList<StudentBean>();

		PreparedStatement statement = connection.prepareStatement(DISPLAY_QUERY);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			StudentBean studentBean = new StudentBean();
			studentBean.setId(resultSet.getInt(ONE));
			studentBean.setName(resultSet.getString(TWO));
			studentBean.setAddress(resultSet.getString(THREE));
			
			listOfStudent.add(studentBean);
		}
		return listOfStudent;
	}
}

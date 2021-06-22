package com.tuananh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuananh.model.EmployeeModel;

public class EmployeeMapper implements RowMapper<EmployeeModel>{
	@Override
	public EmployeeModel mapRow(ResultSet resultSet) {
		try {
			EmployeeModel employee = new EmployeeModel();
			employee.setId(resultSet.getLong("id"));
			employee.setName(resultSet.getString("name"));
			employee.setBirthday(resultSet.getDate("birthday"));
			employee.setGender(resultSet.getBoolean("gender"));
			employee.setContact(resultSet.getString("contact"));
			employee.setEmail(resultSet.getString("email"));
			employee.setStatus(resultSet.getString("status"));
			employee.setIdentity(resultSet.getString("identity"));
			employee.setImage(resultSet.getString("image"));
			return employee;
		} catch (SQLException e) {
			return null;
		}
		
	}
}

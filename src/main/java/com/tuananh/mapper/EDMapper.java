package com.tuananh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuananh.model.Employee_Department;

public class EDMapper implements RowMapper<Employee_Department>{

	@Override
	public Employee_Department mapRow(ResultSet resultSet) {
		try {
			Employee_Department employee_department = new Employee_Department();
			employee_department.setEmployeeId(resultSet.getLong("id_employee"));
			employee_department.setDepartmentId(resultSet.getLong("id_department"));
			employee_department.setStartDate(resultSet.getDate("start_date"));

			return employee_department;
		} catch (SQLException e) {
			return null;
		}
	}

}

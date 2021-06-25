package com.tuananh.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tuananh.model.DepartmentModel;

public class DepartmentMapper implements RowMapper<DepartmentModel>{

	@Override
	public DepartmentModel mapRow(ResultSet resultSet) {
		try {
			DepartmentModel department = new DepartmentModel();
			department.setId(resultSet.getLong("id"));
			department.setName(resultSet.getString("name"));
			department.setDescription(resultSet.getString("description"));
			
			return department;
		} catch (SQLException e) {
			return null;
		}
	}

}

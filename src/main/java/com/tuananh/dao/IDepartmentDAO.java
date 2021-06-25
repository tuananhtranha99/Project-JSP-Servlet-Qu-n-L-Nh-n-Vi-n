package com.tuananh.dao;

import java.util.List;

import com.tuananh.model.DepartmentModel;

public interface IDepartmentDAO {
	List<DepartmentModel> findAll();
	List<DepartmentModel> findByEmployeeId(Long employeeId);
}

package com.tuananh.dao;

import java.util.List;

import com.tuananh.model.EmployeeModel;

public interface IEmployeeDAO {
	EmployeeModel findOne(Long id);
	List<EmployeeModel> findByDepartmentId(Long departmentId);
	Long save(EmployeeModel employeeModel);
	void update(EmployeeModel updateEmployee);
	void delete(long id);
}

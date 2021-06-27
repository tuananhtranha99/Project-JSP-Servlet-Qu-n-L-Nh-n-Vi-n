package com.tuananh.service;

import java.util.List;

import com.tuananh.model.DepartmentModel;
import com.tuananh.model.EmployeeModel;

public interface IDepartmentService {
	List<DepartmentModel> findAll();
	List<DepartmentModel> findByEmployeeId(Long employeeId);
	DepartmentModel findOne(Long id);
	DepartmentModel save(DepartmentModel departmentModel);
	DepartmentModel update(DepartmentModel updateDepartment);
	void delete(long[] ids);
}

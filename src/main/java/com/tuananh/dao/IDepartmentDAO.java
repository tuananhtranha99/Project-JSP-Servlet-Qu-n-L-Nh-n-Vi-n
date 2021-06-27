package com.tuananh.dao;

import java.util.List;

import com.tuananh.model.DepartmentModel;
import com.tuananh.model.EmployeeModel;

public interface IDepartmentDAO {
	List<DepartmentModel> findAll();
	List<DepartmentModel> findByEmployeeId(Long employeeId);
	DepartmentModel findOne(Long id);
	void deleteByEmployeeId(Long employeeId);
	void saveDepartmentAndEmployee(Long employeeId, Long departmentId);
	Long save(DepartmentModel departmentModel);
	void update(DepartmentModel updateDepartment);
	void delete(long id);
}

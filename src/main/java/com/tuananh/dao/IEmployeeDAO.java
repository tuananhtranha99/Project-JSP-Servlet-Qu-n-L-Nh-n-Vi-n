package com.tuananh.dao;

import java.util.List;

import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.Pageble;

public interface IEmployeeDAO {
	EmployeeModel findOne(Long id);
	List<EmployeeModel> findByDepartmentId(Long departmentId);
	Long save(EmployeeModel employeeModel);
	void update(EmployeeModel updateEmployee);
	void delete(long id);
	List<EmployeeModel> findAll(Pageble pageble);
	int getTotalItem();
}

package com.tuananh.service;

import java.util.List;

import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.Pageble;

public interface IEmployeeService {
	List<EmployeeModel> findByDepartmentId(Long departmentId);
	EmployeeModel save(EmployeeModel employeeModel);
	EmployeeModel update(EmployeeModel updateEmployee);
	void delete(long[] ids);
	List<EmployeeModel> findAll(Pageble pageble);
	int getTotalItem();
	EmployeeModel findOne(long id);
//	List<EmployeeModel> findByName(Pageble pageble, String employeeName);
	List<EmployeeModel> findTop3();

}

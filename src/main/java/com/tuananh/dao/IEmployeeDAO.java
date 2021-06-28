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
	void deleteByDepartmentId(Long departmentId);
	List<EmployeeModel> findAll(Pageble pageble);
	int getTotalItem();
//	List<EmployeeModel> findByName(Pageble pageble, String employeeName);
	List<EmployeeModel> findTop3();
}

package com.tuananh.service;

import java.util.List;

import com.tuananh.model.DepartmentModel;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.Pageble;

public interface IDepartmentService {
	List<DepartmentModel> findAll();
	List<DepartmentModel> findByEmployeeId(Long employeeId);
	DepartmentModel findOne(Long id);
	DepartmentModel save(DepartmentModel departmentModel);
	DepartmentModel update(DepartmentModel updateDepartment);
	void delete(long[] ids);
	List<DepartmentModel> searchByName(Pageble pageble, String departmentName);
	List<DepartmentModel> findTop7(Pageble pageble);
	List<DepartmentModel> getNext3(Pageble pageble,int offset);

}

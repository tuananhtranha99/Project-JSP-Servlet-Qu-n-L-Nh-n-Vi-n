package com.tuananh.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import com.tuananh.dao.IDepartmentDAO;
import com.tuananh.model.DepartmentModel;
import com.tuananh.model.EmployeeModel;
import com.tuananh.service.IDepartmentService;

public class DepartmentService implements IDepartmentService{
	@Inject
	private IDepartmentDAO departmentDAO;
	
	@Override
	public List<DepartmentModel> findAll() {
		// TODO Auto-generated method stub
		return departmentDAO.findAll();
	}

	@Override
	public List<DepartmentModel> findByEmployeeId(Long employeeId) {
		// TODO Auto-generated method stub
		return departmentDAO.findByEmployeeId(employeeId);
	}

	@Override
	public DepartmentModel findOne(Long id) {
		// TODO Auto-generated method stub
		return departmentDAO.findOne(id);
	}

	@Override
	public DepartmentModel save(DepartmentModel departmentModel) {
		Long departmentId = departmentDAO.save(departmentModel);
		return departmentDAO.findOne(departmentId);
	}

	@Override
	public DepartmentModel update(DepartmentModel updateDepartment) {
		departmentDAO.update(updateDepartment);
		return departmentDAO.findOne(updateDepartment.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			departmentDAO.delete(id);
		}
		
	}

}

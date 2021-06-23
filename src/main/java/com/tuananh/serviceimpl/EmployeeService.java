package com.tuananh.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import com.tuananh.dao.IEmployeeDAO;
import com.tuananh.model.EmployeeModel;
import com.tuananh.service.IEmployeeService;

public class EmployeeService implements IEmployeeService{
	@Inject
	private IEmployeeDAO employeeDAO;

	@Override
	public List<EmployeeModel> findByDepartmentId(Long departmentId) {
		// TODO Auto-generated method stub
		return employeeDAO.findByDepartmentId(departmentId);
	}

	@Override
	public EmployeeModel save(EmployeeModel employeeModel) {
		Long employeeId = employeeDAO.save(employeeModel);
		return employeeDAO.findOne(employeeId);
	}

	@Override
	public EmployeeModel update(EmployeeModel updateEmployee) {
		employeeDAO.update(updateEmployee);
		return employeeDAO.findOne(updateEmployee.getId());
	}

	@Override
	public void delete(long[] ids) {
		for(long id : ids) {
			employeeDAO.delete(id);
		}
	}

	@Override
	public List<EmployeeModel> findAll(int offset, int limit) {
		return employeeDAO.findAll(offset, limit);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return employeeDAO.getTotalItem();
	}


}

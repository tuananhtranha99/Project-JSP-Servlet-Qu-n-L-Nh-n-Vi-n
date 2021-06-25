package com.tuananh.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.tuananh.dao.IDepartmentDAO;
import com.tuananh.dao.IEmployeeDAO;
import com.tuananh.model.DepartmentModel;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.Pageble;
import com.tuananh.service.IEmployeeService;

public class EmployeeService implements IEmployeeService{
	@Inject
	private IEmployeeDAO employeeDAO;
	
	@Inject 
	private IDepartmentDAO departmentDAO;

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
	public List<EmployeeModel> findAll(Pageble pageble) {
		return employeeDAO.findAll(pageble);
	}

	@Override
	public int getTotalItem() {
		// TODO Auto-generated method stub
		return employeeDAO.getTotalItem();
	}

	@Override
	public EmployeeModel findOne(long id) {
		EmployeeModel employeeModel = employeeDAO.findOne(id);
		List<DepartmentModel> departmentModels = departmentDAO.findByEmployeeId(id);
		if(!departmentModels.isEmpty()) {
			employeeModel.setDepartmentIds(departmentModels);
		}

		return employeeModel;
	}


}

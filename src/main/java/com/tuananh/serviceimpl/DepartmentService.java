package com.tuananh.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import com.tuananh.dao.IDepartmentDAO;
import com.tuananh.model.DepartmentModel;
import com.tuananh.service.IDepartmentService;

public class DepartmentService implements IDepartmentService{
	@Inject
	private IDepartmentDAO departmentDAO;
	
	@Override
	public List<DepartmentModel> findAll() {
		// TODO Auto-generated method stub
		return departmentDAO.findAll();
	}

}

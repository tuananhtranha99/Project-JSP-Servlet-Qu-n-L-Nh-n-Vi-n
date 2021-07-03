package com.tuananh.serviceimpl;

import java.util.List;

import javax.inject.Inject;

import com.tuananh.dao.IDepartmentDAO;
import com.tuananh.dao.IEmployeeDAO;
import com.tuananh.model.DepartmentModel;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.Pageble;
import com.tuananh.service.IDepartmentService;

public class DepartmentService implements IDepartmentService{
	@Inject
	private IDepartmentDAO departmentDAO;
	
	@Inject 
	private IEmployeeDAO employeeDAO;
	
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
		List<Long> list = departmentModel.getEmployeeIdMapping();
		Long departmentId = departmentDAO.save(departmentModel);
		for (Long o : list) {
			departmentDAO.saveDepartmentAndEmployee( o, departmentId);
		}
		
		return departmentDAO.findOne(departmentId);
	}

	@Override
	public DepartmentModel update(DepartmentModel updateDepartment) {
		List<Long> list = updateDepartment.getEmployeeIdMapping(); // danh sách employee mà client gửi lên (theo id)
		List<EmployeeModel> employeeExisted = employeeDAO.findByDepartmentId(updateDepartment.getId()); // danh sách
																											// employee
																											// (theo id)
		if (!employeeExisted.isEmpty()) {
			employeeDAO.deleteByDepartmentId(updateDepartment.getId());
		}

		for (Long o : list) {
			departmentDAO.saveDepartmentAndEmployee( o, updateDepartment.getId());
		}
		departmentDAO.update(updateDepartment);
		return departmentDAO.findOne(updateDepartment.getId());
	}

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			departmentDAO.delete(id);
			
		}
		
	}

	@Override
	public List<DepartmentModel> searchByName(Pageble pageble, String departmentName) {
		// TODO Auto-generated method stub
		return departmentDAO.searchByName(pageble, departmentName);
	}

	@Override
	public List<DepartmentModel> findTop7(Pageble pageble) {
		// TODO Auto-generated method stub
		return departmentDAO.findTop7(pageble);
	}

	@Override
	public List<DepartmentModel> getNext3(Pageble pageble, int offset) {
		// TODO Auto-generated method stub
		return departmentDAO.getNext3(pageble, offset);
	}
}

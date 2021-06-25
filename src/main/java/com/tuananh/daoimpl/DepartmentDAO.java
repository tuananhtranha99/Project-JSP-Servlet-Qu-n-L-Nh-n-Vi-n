package com.tuananh.daoimpl;

import java.util.List;

import com.tuananh.dao.IDepartmentDAO;
import com.tuananh.mapper.DepartmentMapper;
import com.tuananh.model.DepartmentModel;

public class DepartmentDAO extends AbstractDAO<DepartmentModel> implements IDepartmentDAO {

	@Override
	public List<DepartmentModel> findAll() {
		String sql = "select * from department where deleted = 0";
		return query(sql, new DepartmentMapper());
	}

	@Override
	public List<DepartmentModel> findByEmployeeId(Long employeeId) {
		StringBuilder sql = new StringBuilder("select department.* from department"); 
				sql.append(" join employee_department on department.id = employee_department.id_department") ;
				sql.append(" join employee on employee.id = employee_department.id_employee"); 
				sql.append(" where employee.deleted = 0 and id_employee = ?");
		return query(sql.toString(), new DepartmentMapper(), employeeId);
	}

}

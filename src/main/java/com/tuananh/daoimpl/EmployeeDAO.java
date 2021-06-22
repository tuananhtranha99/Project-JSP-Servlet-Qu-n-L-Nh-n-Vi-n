package com.tuananh.daoimpl;

import java.util.List;

import com.tuananh.dao.IEmployeeDAO;
import com.tuananh.mapper.EmployeeMapper;
import com.tuananh.model.EmployeeModel;

public class EmployeeDAO extends AbstractDAO<EmployeeModel> implements IEmployeeDAO{

	@Override
	public EmployeeModel findOne(Long id) {
		String sql = "select * from employee where id = ? and deleted = 0";
		List<EmployeeModel> employee = query(sql, new EmployeeMapper(), id);
		return employee.isEmpty() ? null : employee.get(0);
	}

	@Override
	public List<EmployeeModel> findByDepartmentId(Long departmentId) {
		StringBuilder sql = new StringBuilder("select employee.* from employee join employee_department on employee.id = employee_department.id_employee");
		sql.append(" where id_department = ? and employee.deleted = 0");
		return query(sql.toString(), new EmployeeMapper(), departmentId);
	}

	@Override
	public Long save(EmployeeModel employeeModel) {
		StringBuilder sql = new StringBuilder("Insert into employee(name, birthday, ");
		sql.append(" gender, image, contact, email, status, identity) ");
		sql.append("values (?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), employeeModel.getName(), employeeModel.getBirthday(), employeeModel.isGender(), 
				employeeModel.getImage(), employeeModel.getContact(), employeeModel.getEmail(), employeeModel.getStatus(),
				employeeModel.getIdentity());
	}

	@Override
	public void update(EmployeeModel updateEmployee) {
		StringBuilder sql = new StringBuilder("Update employee set ");
		sql.append("name = ?,");
		sql.append(" birthday = ?,");
		sql.append(" gender = ?,");
		sql.append(" image = ?,");
		sql.append(" contact = ?,");
		sql.append(" email = ?,");
		sql.append(" status = ?, identity = ?");
		sql.append(" where id = ?");
		update(sql.toString(), updateEmployee.getName(), updateEmployee.getBirthday(), updateEmployee.isGender(), 
				updateEmployee.getImage(), updateEmployee.getContact(), updateEmployee.getEmail(), updateEmployee.getStatus(),
				updateEmployee.getIdentity(), updateEmployee.getId());
		
	}

	@Override
	public void delete(long id) {
		String sql = "update employee set deleted = b'1' where id = ?";
		update(sql, id);
		
	}

}

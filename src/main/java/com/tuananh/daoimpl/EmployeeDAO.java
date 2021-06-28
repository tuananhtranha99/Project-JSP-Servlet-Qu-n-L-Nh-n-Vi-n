package com.tuananh.daoimpl;

import java.util.List;

import com.mysql.cj.util.StringUtils;
import com.tuananh.dao.IEmployeeDAO;
import com.tuananh.mapper.EmployeeMapper;
import com.tuananh.model.EmployeeModel;
import com.tuananh.paging.Pageble;

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

	@Override
	public List<EmployeeModel> findAll(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from employee");
		sql.append(" where deleted = 0");
		if(pageble.getSorter().getSortName() != null && pageble.getSorter().getSortBy() != null) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if(pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" limit " + pageble.getOffset() + ", " + pageble.getLimit());
		} 
		
		return query(sql.toString(), new EmployeeMapper());
	}

	@Override
	public int getTotalItem() {
		String sql = "select count(*) from employee where deleted = 0";
		return count(sql);
	}

//	@Override
//	public List<EmployeeModel> findByName(Pageble pageble, String employeeName) {
//		StringBuilder sql = new StringBuilder("select * from employee where name like ? and deleted = 0");
//		if(pageble.getSorter().getSortName() != null && !pageble.getSorter().getSortName().isEmpty() && pageble.getSorter().getSortBy() != null && !pageble.getSorter().getSortBy().isEmpty()) {
//			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
//		}
//		if(pageble.getOffset() != null && pageble.getLimit() != null) {
//			sql.append(" limit " + pageble.getOffset() + ", " + pageble.getLimit());
//		} 
//		return query(sql.toString(), new EmployeeMapper(),"%" + employeeName + "%");
//	}

	@Override
	public List<EmployeeModel> findTop3() {
		StringBuilder sql = new StringBuilder("select * from employee where deleted = 0 limit 3");
		return query(sql.toString(), new EmployeeMapper());
	}

	@Override
	public void deleteByDepartmentId(Long departmentId) {
		// TODO Auto-generated method stub
		
	}

	

}

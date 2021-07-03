package com.tuananh.daoimpl;

import java.util.List;

import com.tuananh.dao.IDepartmentDAO;
import com.tuananh.mapper.DepartmentMapper;
import com.tuananh.model.DepartmentModel;
import com.tuananh.paging.Pageble;

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

	@Override
	public DepartmentModel findOne(Long id) {
		String sql = "select * from department where deleted = 0 and id = ?";
		return query(sql, new DepartmentMapper(), id).get(0);
	}

	@Override
	public void deleteByEmployeeId(Long employeeId) {
		String sql = "delete from employee_department where id_employee = ?";
		update(sql, employeeId);
	}

	@Override
	public void saveDepartmentAndEmployee(Long employeeId, Long departmentId) {
		String sql = "insert into employee_department(id_employee, id_department) values (?, ?)";
		insert2(sql, employeeId, departmentId);
	}

	@Override
	public Long save(DepartmentModel departmentModel) {
		StringBuilder sql = new StringBuilder("Insert into department(name, description)");
		sql.append(" values (?, ?)");
		return insert(sql.toString(), departmentModel.getName(), departmentModel.getDescription());
	}

	@Override
	public void update(DepartmentModel updateDepartment) {
		StringBuilder sql = new StringBuilder("Update department set ");
		sql.append("name = ?,");
		sql.append(" description = ? where id = ?");
		update(sql.toString(), updateDepartment.getName(), updateDepartment.getDescription(), updateDepartment.getId());
	}

	@Override
	public void delete(long id) {
		String sql = "update department set deleted = b'1' where id = ?";
		update(sql, id);
	}

	@Override
	public List<DepartmentModel> searchByName(Pageble pageble, String departmentName) {
		StringBuilder sql = new StringBuilder("select * from department where name like ? and deleted = 0");
		if(pageble.getSorter().getSortName() != null && !pageble.getSorter().getSortName().isEmpty() && pageble.getSorter().getSortBy() != null && !pageble.getSorter().getSortBy().isEmpty()) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		}
		if(pageble.getOffset() != null && pageble.getLimit() != null) {
			sql.append(" limit " + pageble.getOffset() + ", " + pageble.getLimit());
		} 
		return query(sql.toString(), new DepartmentMapper(),"%" + departmentName + "%");
	}

	@Override
	public List<DepartmentModel> findTop7(Pageble pageble) {
		StringBuilder sql = new StringBuilder("select * from department where deleted = 0");
		if(pageble.getSorter().getSortName() != null && !pageble.getSorter().getSortName().isEmpty() && pageble.getSorter().getSortBy() != null && !pageble.getSorter().getSortBy().isEmpty()) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		} 
		sql.append(" limit 10");
		return query(sql.toString(), new DepartmentMapper());
	}

	@Override
	public List<DepartmentModel> getNext3(Pageble pageble, int offset) {
		StringBuilder sql = new StringBuilder("select * from department where deleted = 0 ");
		if(pageble.getSorter().getSortName() != null && !pageble.getSorter().getSortName().isEmpty() && pageble.getSorter().getSortBy() != null && !pageble.getSorter().getSortBy().isEmpty()) {
			sql.append(" order by " + pageble.getSorter().getSortName() + " " + pageble.getSorter().getSortBy());
		} 
		sql.append(" limit ?, 3");
		return query(sql.toString(), new DepartmentMapper(), offset);
	}

	

}

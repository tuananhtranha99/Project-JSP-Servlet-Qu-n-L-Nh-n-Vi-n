package com.tuananh.model;

import java.util.ArrayList;
import java.util.List;

public class DepartmentModel extends AbstractModel<DepartmentModel> implements Comparable<DepartmentModel>{
	private String name;
	private String description;
	private boolean deleted;
	private List<EmployeeModel> employeeList = new ArrayList<>();
	private List<Long> employeeIdMapping = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof DepartmentModel)) {
            return false;
        }
		DepartmentModel other = (DepartmentModel)obj;
		return other.getId().equals(this.getId());
	}
	@Override
	public int compareTo(DepartmentModel o) {
		// TODO Auto-generated method stub
		return (int) (this.getId() - o.getId());
	}
	public List<EmployeeModel> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<EmployeeModel> employeeList) {
		this.employeeList = employeeList;
	}
	public List<Long> getEmployeeIdMapping() {
		return employeeIdMapping;
	}
	public void setEmployeeIdMapping(List<Long> employeeIdMapping) {
		this.employeeIdMapping = employeeIdMapping;
	}
}

package com.tuananh.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel extends AbstractModel<EmployeeModel> implements Comparable<EmployeeModel>{
	private String name;
	private Date birthday;
	private boolean gender;
	private String image;
	private String contact;
	private String email;
	private String status;
	private String identity;
	private boolean deleted;
	private List<DepartmentModel> departmentIds = new ArrayList<>();
	private List<ProjectModel> projectIds = new ArrayList<>();
	private List<Long> departmentIdMapping =  new ArrayList<>();
	private Long idDetails;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	public List<DepartmentModel> getDepartmentIds() {
		return departmentIds;
	}
	public void setDepartmentIds(List<DepartmentModel> departmentIds) {
		this.departmentIds = departmentIds;
	}
	public List<ProjectModel> getProjectIds() {
		return projectIds;
	}
	public void setProjectIds(List<ProjectModel> projectIds) {
		this.projectIds = projectIds;
	}
	public List<Long> getDepartmentIdMapping() {
		return departmentIdMapping;
	}
	public void setDepartmentIdMapping(List<Long> departmentIdMapping) {
		this.departmentIdMapping = departmentIdMapping;
	}
	public Long getIdDetails() {
		return idDetails;
	}
	public void setIdDetails(Long idDetails) {
		this.idDetails = idDetails;
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof EmployeeModel)) {
            return false;
        }
		EmployeeModel other = (EmployeeModel)obj;
		return other.getId().equals(this.getId());
	}
	@Override
	public int compareTo(EmployeeModel o) {
		// TODO Auto-generated method stub
		return (int) (this.getId() - o.getId());
	}
}

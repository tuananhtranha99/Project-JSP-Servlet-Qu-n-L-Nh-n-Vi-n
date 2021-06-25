package com.tuananh.model;

public class DepartmentModel extends AbstractModel<DepartmentModel> implements Comparable<DepartmentModel>{
	private String name;
	private String description;
	private boolean deleted;
	private String check;
	
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
	public String getCheck() {
		return check;
	}
	public void setCheck(String check) {
		this.check = check;
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
}

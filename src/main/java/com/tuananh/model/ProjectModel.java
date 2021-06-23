package com.tuananh.model;

import java.time.LocalDate;

public class ProjectModel extends AbstractModel<ProjectModel>{
	private String name;
	private String description;
	private LocalDate start_date;
	private LocalDate finish_date;
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
	public LocalDate getStart_date() {
		return start_date;
	}
	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}
	public LocalDate getFinish_date() {
		return finish_date;
	}
	public void setFinish_date(LocalDate finish_date) {
		this.finish_date = finish_date;
	}
	
	
}

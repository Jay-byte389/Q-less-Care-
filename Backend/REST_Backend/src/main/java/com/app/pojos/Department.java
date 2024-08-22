package com.app.pojos;


import javax.persistence.Column;

import javax.persistence.Entity;



@Entity
public class Department extends BaseEntity  {

	@Column(length = 30)
	private String department;

	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public Department() {
		// TODO Auto-generated constructor stub
	}
	
	
}

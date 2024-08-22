package com.app.pojos;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Medicine")
public class Medicine extends BaseEntity  {
	

	@Column(name="Name")
	private String name;
	@Column(name="Company")
	private String company;

	public Medicine() {
		
	}
	
	

	public Medicine(String name, String company) {
		super();
		this.name = name;
		this.company = company;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "Medicine [name=" + name + ", company=" + company + "]";
	}

}

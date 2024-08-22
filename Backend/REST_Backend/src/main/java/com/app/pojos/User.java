package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User extends BaseEntity {

	@Column(length = 20,nullable = false)
	private String username;
	@Column(length = 20,nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role userRole;
	private UserValidity validity;
	
	public User() {
		
	}

	
	public UserValidity getValidity() {
		return validity;
	}


	public void setValidity(UserValidity validity) {
		this.validity = validity;
	}


	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", userRole=" + userRole + "]";
	}

	
	
	
	public User(String username, String password, Role userRole) {
		this.username = username;
		this.password = password;
		this.userRole = userRole;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getUserRole() {
		return userRole;
	}

	public void setUserRole(Role userRole) {
		this.userRole = userRole;
	}
	
	
}

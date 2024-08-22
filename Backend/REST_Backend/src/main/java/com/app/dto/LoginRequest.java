package com.app.dto;

import javax.validation.constraints.NotBlank;

public class LoginRequest {
	
	@NotBlank(message = "username is required !!!!")
	private String username;
	@NotBlank(message = "Password required !!!!")
	private String password;
	
	public LoginRequest() {
		// TODO Auto-generated constructor stub
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
	
	
}

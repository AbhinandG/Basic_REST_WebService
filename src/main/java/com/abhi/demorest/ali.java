package com.abhi.demorest;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ali {
	
	
	private String username;
	private String password;
	
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
	@Override
	public String toString() {
		return "ali [username=" + username + ", password=" + password + "]";
	}
	
}

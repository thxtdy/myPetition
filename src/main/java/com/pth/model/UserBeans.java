package com.pth.model;

import java.io.Serializable;

public class UserBeans implements Serializable{
	
	private String username;
	private String email;
	private String userid;
	private String userpw;
	
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getUserid() {
		return userid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}
	
	
}

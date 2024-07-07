package com.pth.model;

public class Users {
	
	private String username;
	private String email;
	private String userid;
	private String userpw;
	
	public Users(String username, String email, String userid, String userpw) {
		this.username = username;
		this.email = email;
		this.userid = userid;
		this.userpw = userpw;
	}
	
	public String getUsername() {
		return username;
	}
	public String getEmail() {
		return email;
	}
	public String getUserid() {
		return userid;
	}
	public String getUserpw() {
		return userpw;
	}
	public boolean matchId(String userid) {
		return userid.equals(userid);
	}
	public boolean matchPassword(String userpw) {
		return userpw.equals(userpw);
	}
	
}

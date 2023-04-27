package com.advj.pojo;

public class Login {
    private int userid;
    private String username;
    private String password;
    Login()
    {
    	//advance java
    }
    Login(String username,String password)
    {
    	super();
    	this.username=username;
    	this.password=password;
    }
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
    
}

package com.nuist.sql;

public class userModel {

	private String Name;
	private String Pass;
	
	public userModel() {
		super();
	}

	public userModel(String name, String pass) {
		super();
		Name = name;
		Pass = pass;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}
	
	
}

package com.nuist.sql;

public class user {

	private String Name;
	private String Pass;
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
	public user(){
		
	}
	public void user(String name,String pass){
		this.Name=name;
		this.Pass=pass;
	}
	
}

package com.model;

public class UserLogin {
	private String Username;
	private String Password;
	public UserLogin(String Username, String Password)
	{
		super();
		this.Username=Username;
		this.Password=Password;
	}
	public String getUsername()
	{
		return Username;
	}
	public void setUsername(String Username)
	{
		this.Username=Username;
	}
	public String getPassword()
	{
		return Password;
	}
	public void setPassword(String Password)
	{
		this.Password=Password;
	}
	@Override
	public String toString()
	{
		String User_Details;
		User_Details="User [Username= " + Username + ",Password= " + Password + "]";
		return User_Details;
	}

}

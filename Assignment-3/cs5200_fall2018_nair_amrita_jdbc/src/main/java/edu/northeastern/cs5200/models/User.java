package edu.northeastern.cs5200.models;

import java.sql.Date;

public class User extends Person {
	private Boolean userAgreement= false;

	public User(boolean userAgreement, int pId, String firstName, String lastName, String userName, String password, String email,
			Date dob) {
		super(pId, firstName, lastName, userName, password, email, dob);
		this.userAgreement=userAgreement;
		System.out.println(this.userAgreement);
		// TODO Auto-generated constructor stub
	}
	
	public User(int pId, String firstName, String lastName, String userName, String password, String email,
			Date dob) {
		super(pId, firstName, lastName, userName, password, email, dob);
		
		System.out.println(this.userAgreement);
		// TODO Auto-generated constructor stub
	}
	
	public User(int pId, String firstName, String lastName) {
		super(pId, firstName, lastName);
		// TODO Auto-generated constructor stub
		userAgreement = false;
	}
	
	

	public Boolean getUserAgreement() {
		return userAgreement;
	}

	public void setUserAgreement(Boolean userAgreement) {
		this.userAgreement = userAgreement;
	}
	
	
}

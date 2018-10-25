package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.sql.*;
public class Developer extends Person {


private String developerKey;
private ArrayList<Website> websites;

/*Should create an instance of developer when developer Key, Developer ID, 
 * Developer First Name, Developer Last Name, with rest of the fields with 
 * default values specified by you.*/
public Developer(String developerKey,int pId,String firstName, String lastName) {
	super(pId,firstName,lastName);
	this.developerKey=developerKey;
	
}

public Developer(String developerKey, int pId, String firstName, String lastName, String userName, String password, String email,
		Date dob) {
	super(pId, firstName, lastName, userName, password, email, dob);
	this.developerKey=developerKey;
	System.out.println(this.developerKey);
	// TODO Auto-generated constructor stub
}


public Developer(String developerKey,int pId, String firstName, String lastName, String userName, String password, String email, Date dob,
		ArrayList<Address> address, ArrayList<Phone> phones) {
	super(pId, firstName, lastName, userName, password, email, dob, address, phones);
	this.developerKey=developerKey;
	System.out.println(this.developerKey);
	
	// TODO Auto-generated constructor stub
}

public Developer(String developerKey,int pId, String firstName, String lastName, String userName, String password, String email,
		ArrayList<Address> address) {
	super(pId, firstName, lastName, userName, password, email,  address);
	this.developerKey=developerKey;
	System.out.println(this.developerKey);
	
	// TODO Auto-generated constructor stub
}




public Developer(String developerKey,int pId, String firstName, String lastName, String userName, String password, String email, Date dob,
		 ArrayList<Phone> phones) {
	super(pId, firstName, lastName, userName, password, email, dob, phones);
	this.developerKey=developerKey;
	System.out.println(this.developerKey);
	
	// TODO Auto-generated constructor stub
}

public String getDeveloperKey() {
	System.out.println(this.developerKey);
	return this.developerKey;
}

public void setDeveloperKey(String developerKey) {
	this.developerKey = developerKey;
}

public ArrayList<Website> getWebsites() {
	return websites;
}

public void setWebsites(ArrayList<Website> websites) {
	this.websites = websites;
}


}

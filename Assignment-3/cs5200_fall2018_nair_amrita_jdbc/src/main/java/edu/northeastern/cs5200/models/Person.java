package edu.northeastern.cs5200.models;

import java.util.ArrayList;
import java.sql.*;

public class Person {
	private int pId;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private  Date dob;
	private ArrayList<Address> address;
	private ArrayList<Phone> phones;
	
	
	
	public Person(int pId, String firstName, String lastName) {
		super();
		this.pId = pId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	
	/*Should also create an instance of developer when developer key, developer ID, developer first name,
	 * developer last name, developer user-name, developer password, email and dob are passed as parameters.*/
	
	public Person(int pId, String firstName, String lastName, String userName, String password, String email,
			Date dob) {
		super();
		this.pId = pId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.dob = dob;
	}
	
	public Person(int pId, String firstName, String lastName, String userName, String password, String email,
			Date dob, ArrayList<Phone> phones) {
		super();
		this.pId = pId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.dob = dob;
		
		this.phones = phones;
	}
	
	public Person(int pId, String firstName, String lastName, String userName, String password, String email,
			 ArrayList<Address> address) {
		super();
		this.pId = pId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	public Person(int pId, String firstName, String lastName, String userName, String password, String email,
			Date dob, ArrayList<Address> address, ArrayList<Phone> phones) {
		super();
		this.pId = pId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.dob = dob;
		this.address = address;
		this.phones = phones;
	}


	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getFirstNAme() {
		return firstName;
	}
	public void setFirstNAme(String firstNAme) {
		this.firstName = firstNAme;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public ArrayList<Address> getAddress() {
		return address;
	}
	public void setAddress(ArrayList<Address> address) {
		this.address = address;
	}
	public ArrayList<Phone> getPhones() {
		return phones;
	}
	public void setPhones(ArrayList<Phone> phones) {
		this.phones = phones;
	}
	
	

}

package edu.northeastern.cs5200.models;

public class Address {
private int id;
private String street;
private String city;
private String state;
private String zip;
private boolean primary;
public Address(int id,String street, String city, String state, String zip, boolean primary) {
	super();
	this.id=id;
	this.street = street;
	this.city = city;
	this.state = state;
	this.zip = zip;
	this.primary = primary;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getStreet() {
	return street;
}
public void setStreet(String street) {
	this.street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getZip() {
	return zip;
}
public void setZip(String zip) {
	this.zip = zip;
}
public boolean isPrimary() {
	return primary;
}
public void setPrimary(boolean primary) {
	this.primary = primary;
}


}

package edu.northeastern.cs5200.models;

public class Phone {
	private int id;
	private String phone;
	private boolean primary;
	public Phone(int id, String phone, boolean primary) {
		this.id=id;
		this.phone = phone;
		this.primary = primary;
	}
	public String getPhone(int id) {
		if(this.id==id)
		return phone;
		return "";
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isPrimary(int id) {
		if(this.id==id)
		return primary;
		else return false;
	
	}
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}
	

}

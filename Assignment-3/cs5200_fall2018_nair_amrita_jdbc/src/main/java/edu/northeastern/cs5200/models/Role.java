package edu.northeastern.cs5200.models;

public enum Role {
	 owner(1),admin(2),writer(3),editor(4),reviewer(5);
	

	 public final int fId;

	    private Role(int id) {
	        this.fId = id;
	    }

	    public static Role getValue(int id) {
	    	  return values()[id - 1];
	        }
	   
	
}

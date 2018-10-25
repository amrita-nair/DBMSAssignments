package edu.northeastern.cs5200.models;

public enum Privilege {
	create(1),read(2),update(3),delete(4);


		 public final int fId;

		    private Privilege(int id) {
		        this.fId = id;
		    }

		    public static Privilege getValue(int id) {
		    	  return values()[id - 1];
		        }
		   
		
	}


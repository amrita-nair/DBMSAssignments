package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.User;

public class UserDao implements UserImpl{
	
	Statement statement = null;
	ResultSet results = null;
	//Connection conn=null;
	private static UserDao instance = null;

	private UserDao() {
	}
	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}


	@Override
	public void createUser(User user) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		//Developer(developerKey,int pId,String firstName, String lastName);
		int id = user.getpId();
		String firstName = user.getFirstNAme();
		String lastName = user.getLastName();
		String username = user.getUserName();
		String email = user.getEmail();
		String password = user.getPassword();
		boolean userAgreement=user.getUserAgreement(); 
		ArrayList<Address> address = user.getAddress();
		ArrayList<Phone> phones = user.getPhones();
		 
		
		
		String dob = null;
		try {
			Statement s1 = connection.createStatement();
			Statement s2 = connection.createStatement();
			int UAValue=0;
			if(userAgreement)
				UAValue=1;
			// statement = connection.createStatement();
			String sql1 = "Insert into person VALUES\r\n" + 
					"("+id+",\r\n" + 
					"\""+firstName +"\",\r\n" + 
					"\""+lastName+"\",\r\n" + 
					"\""+username+"\",\r\n" + 
					"\""+password+"\",\r\n" + 
					"\""+email+"\",\r\n" + 
					dob+");\r\n" ;
			System.out.println(sql1);
			String sql2 = "Insert into user values (\"" + id + "\",\"" + UAValue + "\");";
	    	s1.executeUpdate(sql1);
			s2.executeUpdate(sql2);

		
				
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}

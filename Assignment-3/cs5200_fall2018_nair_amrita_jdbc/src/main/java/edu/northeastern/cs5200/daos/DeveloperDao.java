package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Phone;

public class DeveloperDao implements DeveloperImpl {
	Statement statement = null;
	ResultSet results = null;
	//Connection conn=null;
	private static DeveloperDao instance = null;

	private DeveloperDao() {
	}
	public static DeveloperDao getInstance() {
		if (instance == null) {
			instance = new DeveloperDao();
		}
		return instance;
	}

	

	@Override 
	public void createDeveloper(Developer developer) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		//Developer(developerKey,int pId,String firstName, String lastName);
		int id = developer.getpId();
		String firstName = developer.getFirstNAme();
		String lastName = developer.getLastName();
		String username = developer.getUserName();
		String email = developer.getEmail();
		String password = developer.getPassword();
		String developerKey = developer.getDeveloperKey();
		ArrayList<Address> address = developer.getAddress();
		ArrayList<Phone> phones = developer.getPhones();
		 
		
		
		String dob = null;
		try {
			Statement s1 = connection.createStatement();
			Statement s2 = connection.createStatement();

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
			String sql2 = "Insert into developer values (\"" + id + "\",\"" + developerKey + "\");";
	    	s1.executeUpdate(sql1);
			s2.executeUpdate(sql2);

			int i = 0;
			String sql = null;
			for (Phone p : phones) {
				if (p != null) {
					Statement s3 = connection.createStatement();
					int primaryFlag=0;
					if(p.isPrimary(id))
						primaryFlag=1;
					sql = "Insert into phone values (" + p.getId() + ",\"" + p.getPhone(id) + "\","
							+ primaryFlag + ");";
					System.out.println(sql);
					s3.executeUpdate(sql);
					
				}
			}

			for (Address a : address) {
				if (a != null) {
					Statement s4 = connection.createStatement();
					int primaryFlag=0;
					if(a.isPrimary())
						primaryFlag=1;
					sql = "INSERT INTO address\r\n" + 
							"(\r\n" + 
							"`person_id`,\r\n" + 
							"`street1`,\r\n" + 
							"`city`,\r\n" + 
							"`state`,\r\n" + 
							"`zip`,\r\n" + 
							"`primary`)\r\n" + 
							"VALUES (" + a.getId() + ",\""
							+ a.getStreet() + "\",\"" + a.getCity() + "\"," + a.getState() + ",\"" + a.getZip() + "\","
							+ primaryFlag + ")";
					System.out.println(sql);
					s4.executeUpdate(sql);
					
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Developer> findAllDevelopers() {
		List<Developer> developers= new ArrayList<Developer>();
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findAllDevelopers="select * from person,developer\r\n" + 
				"where person.p_id=developer.p_id; ";
	
			Statement s1 = connection.createStatement();
			results = s1.executeQuery(findAllDevelopers);
			
			while(results.next()) {
				int id= results.getInt("p_id");
				String firstName = results.getString("first_name");
				String lastName = results.getString("first_name");
				String userName = results.getString("user_name");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				int pId= results.getInt("p_id");
				String developerKey = results.getString("developer_key");
				Developer dev=new Developer(developerKey,  pId,  firstName,  lastName,  userName,  password,  email,
						 dob);
				developers.add(dev);
				//s1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return developers;
	}

	@Override
	public Developer findDeveloperById(int developerId) {
		Developer developer=null;
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		
		String findDeveloperById="select * from person,developer\r\n" + 
				"where person.p_id=developer.p_id and person.p_id=?;";
			PreparedStatement pStatement = connection.prepareStatement(findDeveloperById);
			pStatement.setInt(1,developerId);
			results = pStatement.executeQuery();
			
			if(results.next()) {
			
				String firstName = results.getString("first_name");
				String lastName = results.getString("first_name");
				String userName = results.getString("user_name");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				int pId= results.getInt("p_id");
				String developerKey = results.getString("developer_key");
				developer=new Developer(developerKey,  pId,  firstName,  lastName,  userName,  password,  email,
						 dob);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return developer;
	}

	@Override
	public Developer findDeveloperByUsername(String username) {
		Developer developer=null;
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		
		String findDeveloperByUsername="select * from person,developer\r\n" + 
				"where person.p_id=developer.p_id and person.user_name=?;";
			PreparedStatement pStatement = connection.prepareStatement(findDeveloperByUsername);
			pStatement.setString(1,username);
			results = pStatement.executeQuery();
			
			if(results.next()) {
			
				String firstName = results.getString("first_name");
				String lastName = results.getString("first_name");
				String userName = results.getString("user_name");
				String password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				int pId= results.getInt("p_id");
				String developerKey = results.getString("developer_key");
				developer=new Developer(developerKey,  pId,  firstName,  lastName,  userName,  password,  email,
						 dob);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return developer;
	}

	@Override
	public Developer findDeveloperByCredentials(String username, String password) {
		Developer developer=null;
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		
		String findDeveloperByCredentials="select * from person,developer\r\n" + 
				"where person.p_id=developer.p_id and person.user_name=? and person.password=?;";
			PreparedStatement pStatement = connection.prepareStatement(findDeveloperByCredentials);
			pStatement.setString(1,username);
			pStatement.setString(2,password);
			results = pStatement.executeQuery();
			
			if(results.next()) {
			
				String firstName = results.getString("first_name");
				String lastName = results.getString("first_name");
				String userName = results.getString("user_name");
				password = results.getString("password");
				String email = results.getString("email");
				Date dob = results.getDate("dob");
				int pId= results.getInt("p_id");
				String developerKey = results.getString("developer_key");
				developer=new Developer(developerKey,  pId,  firstName,  lastName,  userName,  password,  email,
						 dob);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return developer;
	}
	
	
	public int updatePrimaryPhone(int developerId, Phone p) {
		try {		
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		//ArrayList<Address> addressUpdated= developer.getAddress();
		
		String updateDeveloperPhone="Update phone set `phone`=\""+p.getPhone(p.getId())+ "\" where `person_id`="+p.getId()+" and `primary`=1" ;
		
		
		System.out.println(updateDeveloperPhone);	
		
		PreparedStatement pStatement;
		
			pStatement = connection.prepareStatement(updateDeveloperPhone);
		
		pStatement.executeUpdate();
		return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} return 0;
	}

	
	@Override
	public int updateDeveloper(int developerId, Developer developer) {
		
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		//ArrayList<Address> addressUpdated= developer.getAddress();
//		ArrayList<Phone> phoneUpdated= developer.getPhones();
//		for(Phone p: phoneUpdated ) {
//		String updateDeveloperPhone="Update phone set `phone`=\""+p.getPhone(p.getId())+ "\" where person_id="+p.getId()+" and primary=1" ;
//		System.out.println(updateDeveloperPhone);		
//		}
		
		String updateDeveloper= 	"Update developer join person set \r\n" + 
				"`first_name`=\""+developer.getFirstNAme()+"\",\r\n" + 
				"`last_name`=\""+developer.getLastName()+"\",\r\n" +
				"`user_name`=\""+developer.getUserName()+"\",\r\n" +
				"`password`=\""+developer.getPassword()+"\",\r\n" +
				"`email`=\""+developer.getEmail()+"\",\r\n" +
				"`dob`="+developer.getDob()+",\r\n" +
				"`developer_key`=\""+developer.getDeveloperKey()+"\"\r\n" + 
			    "where person.p_id=developer.p_id and person.p_id= ?;\r\n" ; 
				
		System.out.println(updateDeveloper);
			PreparedStatement pStatement = connection.prepareStatement(updateDeveloper);
			pStatement.setInt(1,developerId);
			//pStatement.setString(2,password);
			pStatement.executeUpdate();
			
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	public int deletePrimaryAddress(int developerId) {

		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		
		String deletePrimaryAddress="Delete from address\r\n" + 
				" where `person_id`=?;\r\n" ; 
				
		System.out.println(deletePrimaryAddress);
			PreparedStatement pStatement = connection.prepareStatement(deletePrimaryAddress);
			pStatement.setInt(1,developerId);
			//pStatement.setString(2,password);
			pStatement.executeUpdate();
			
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteDeveloper(int developerId) {

		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		
		String deleteDeveloper="Delete developer,person from developer join person\r\n" + 
				" where person.p_id=developer.p_id and person.p_id=?;\r\n" ; 
				
		System.out.println(deleteDeveloper);
			PreparedStatement pStatement = connection.prepareStatement(deleteDeveloper);
			pStatement.setInt(1,developerId);
			//pStatement.setString(2,password);
			pStatement.executeUpdate();
			
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}

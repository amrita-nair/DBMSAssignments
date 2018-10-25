package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import edu.northeastern.cs5200.models.Privilege;
import edu.northeastern.cs5200.models.Role;

public class PrivilegeDao implements PrivilegeImpl{
	
	Statement statement = null;
	ResultSet results = null;
	private static PrivilegeDao instance = null;
	PrivilegeDao() {
	}
	public static PrivilegeDao getInstance() {
		if (instance == null) {
			instance = new PrivilegeDao();
		}
		return instance;
	}
	@Override
	public void assignWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		
		try {
			Statement s1 = connection.createStatement();
			String assignWebsitePrivilege = "Insert into website_privilege (developer_id, privilege_name, website_id)\r\n" + 
						"VALUES\r\n" + 
						"("+developerId+",\r\n" + 
						"\""+priviledge+"\",\r\n" + 
						+websiteId+"\r\n" +
						");\r\n" ;
			System.out.println(assignWebsitePrivilege);
			s1.executeUpdate(assignWebsitePrivilege);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		
	}
	@Override
	public void assignPagePriviledge(int developerId, int pageId, String priviledge) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		
		try {
			Statement s1 = connection.createStatement();
			String assignPagePrivilege = "Insert into page_privilege (developer_id, privilege, page_id)\r\n" + 
						"VALUES\r\n" + 
						"("+developerId+",\r\n" + 
						"\""+priviledge+"\",\r\n" + 
						+pageId+"\r\n" +
						");\r\n" ;
			System.out.println(assignPagePrivilege);
			s1.executeUpdate(assignPagePrivilege);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteWebsitePriviledge(int developerId, int websiteId, String priviledge) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String deleteWebsitePrivilege="Delete from website_privilege" + 
					" where website_id=? and developer_id=? and privilege_name = ?;\r\n" ; 
					
			System.out.println(deleteWebsitePrivilege);
				PreparedStatement pStatement = connection.prepareStatement(deleteWebsitePrivilege);
				pStatement.setInt(1,websiteId);
				pStatement.setInt(2,developerId);
				//System.out.println(P.getValue(roleId).toString());
				pStatement.setString(3,priviledge);
				
				pStatement.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	@Override
	public void deletePagePriviledge(int developerId, int pageId, String priviledge) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String deletePagePrivilege="Delete from page_privilege" + 
					" where page_id=? and developer_id=? and privilege = ?;\r\n" ; 
					
			System.out.println(deletePagePrivilege);
				PreparedStatement pStatement = connection.prepareStatement(deletePagePrivilege);
				pStatement.setInt(1,pageId);
				pStatement.setInt(2,developerId);
				//System.out.println(P.getValue(roleId).toString());
				pStatement.setString(3,priviledge);
				
				pStatement.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}

	
}

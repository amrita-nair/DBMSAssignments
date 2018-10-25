package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Role;
import edu.northeastern.cs5200.models.Widget;

public class RoleDao implements RoleImpl {
	
	Statement statement = null;
	ResultSet results = null;
	private static RoleDao instance = null;
	private RoleDao() {
	}
	public static RoleDao getInstance() {
		if (instance == null) {
			instance = new RoleDao();
		}
		return instance;
	}
	
	PrivilegeDao privDao=new PrivilegeDao();

	@Override
	public void assignWebsiteRole(int developerId, int websiteId, int roleId) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		
		try {
			Statement s1 = connection.createStatement();
			String assignWebsiteRole = "Insert into website_role (developer_id, role_name, website_id)\r\n" + 
						"VALUES\r\n" + 
						"("+developerId+",\r\n" + 
						"\""+Role.getValue(roleId)+"\",\r\n" + 
						+websiteId+"\r\n" +
						");\r\n" ;
			System.out.println(assignWebsiteRole);
			s1.executeUpdate(assignWebsiteRole);
			
			if(Role.getValue(roleId).toString().equals("admin")||Role.getValue(roleId).toString().equals("owner")) {
				privDao.assignWebsitePriviledge(developerId, websiteId, "create");
				privDao.assignWebsitePriviledge(developerId, websiteId, "read");
				privDao.assignWebsitePriviledge(developerId, websiteId, "update");
				privDao.assignWebsitePriviledge(developerId, websiteId, "delete");
			}
			else if(Role.getValue(roleId).toString().equals("writer")) {
				privDao.assignWebsitePriviledge(developerId, websiteId, "create");
				privDao.assignWebsitePriviledge(developerId, websiteId, "read");
				privDao.assignWebsitePriviledge(developerId, websiteId, "update");
			}
			else if(Role.getValue(roleId).toString().equals("editor")) {
				privDao.assignWebsitePriviledge(developerId, websiteId, "read");
				privDao.assignWebsitePriviledge(developerId, websiteId, "update");
			}
			else if(Role.getValue(roleId).toString().equals("reviewer")) {
				privDao.assignWebsitePriviledge(developerId, websiteId, "read");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		
	}
		
	

	@Override
	public void assignPageRole(int developerId, int pageId, int roleId) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		
		try {
			Statement s1 = connection.createStatement();
			String assignPageRole = "Insert into page_role (developer_id, role, page_id)\r\n" + 
						"VALUES\r\n" + 
						"("+developerId+",\r\n" + 
						"\""+Role.getValue(roleId)+"\",\r\n" + 
						+pageId+"\r\n" +
						");\r\n" ;
			System.out.println(assignPageRole);
			s1.executeUpdate(assignPageRole);
			
			if(Role.getValue(roleId).toString().equals("admin")||Role.getValue(roleId).toString().equals("owner")) {
				privDao.assignPagePriviledge(developerId, pageId, "create");
				privDao.assignPagePriviledge(developerId, pageId, "read");
				privDao.assignPagePriviledge(developerId, pageId, "update");
				privDao.assignPagePriviledge(developerId, pageId, "delete");
			}
			else if(Role.getValue(roleId).toString().equals("writer")) {
				privDao.assignPagePriviledge(developerId, pageId, "create");
				privDao.assignPagePriviledge(developerId, pageId, "read");
				privDao.assignPagePriviledge(developerId, pageId, "update");
			}
			else if(Role.getValue(roleId).toString().equals("editor")) {
				privDao.assignPagePriviledge(developerId, pageId, "read");
				privDao.assignPagePriviledge(developerId, pageId, "update");
			}
			else if(Role.getValue(roleId).toString().equals("reviewer")) {
				privDao.assignPagePriviledge(developerId, pageId, "read");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void swapRolesCNET(int pageId, int charlieId, int bobId) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String roleCharlie="";
		String roleBob="";
	
		int charlieID;
		
		//owner(1),admin(2),writer(3),editor(4),reviewer(5)
		// charlies role in page 123  writer bob reviewer
		// charlies role in page 567  reviewer bob editor
		try {
			Statement s1 = connection.createStatement();
			Statement s2 = connection.createStatement();
			
			
			String charlieRoleByIdCNET= "select `role` from page_role where `page_id`="+pageId+" and `developer_id`=34;";
			String bobRoleByIdCNET= "select `role` from page_role where `page_id`="+pageId+" and `developer_id`=23;";
			
			System.out.println(charlieRoleByIdCNET);
			System.out.println(bobRoleByIdCNET);
			
			results = s2.executeQuery(bobRoleByIdCNET);
			if(results.next()) {
				roleBob = results.getString("role");
				
				deletePageRole(bobId, pageId,Role.valueOf(roleBob).ordinal()+1);
			}
			
			results = s1.executeQuery(charlieRoleByIdCNET);
			
			if(results.next()) {
				roleCharlie = results.getString("role");
				int h=Role.valueOf(roleCharlie).ordinal();
				
		        deletePageRole(charlieId, pageId,Role.valueOf(roleCharlie).ordinal()+1);
			}
			
			
			assignPageRole(charlieId,pageId,Role.valueOf(roleBob).ordinal()+1);
			assignPageRole(bobId,pageId,Role.valueOf(roleCharlie).ordinal()+1);
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteWebsiteRole(int developerId, int websiteId, int roleId) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String deleteWebsiteRole="Delete from website_role" + 
					" where website_id=? and developer_id=? and role_name = ?;\r\n" ; 
					
			System.out.println(deleteWebsiteRole);
				PreparedStatement pStatement = connection.prepareStatement(deleteWebsiteRole);
				pStatement.setInt(1,websiteId);
				pStatement.setInt(2,developerId);
				System.out.println(Role.getValue(roleId).toString());
				pStatement.setString(3,Role.getValue(roleId).toString());
				
				pStatement.executeUpdate();
				if(Role.getValue(roleId).toString().equals("admin")||Role.getValue(roleId).toString().equals("owner")) {
					privDao.deleteWebsitePriviledge(developerId, websiteId,"create");
					privDao.deleteWebsitePriviledge(developerId, websiteId, "read");
					privDao.deleteWebsitePriviledge(developerId, websiteId, "update");
					privDao.deleteWebsitePriviledge(developerId, websiteId, "delete");
				}
				else if(Role.getValue(roleId).toString().equals("writer")) {
					privDao.deleteWebsitePriviledge(developerId, websiteId, "create");
					privDao.deleteWebsitePriviledge(developerId, websiteId, "read");
					privDao.deleteWebsitePriviledge(developerId, websiteId, "update");
				}
				else if(Role.getValue(roleId).toString().equals("editor")) {
					privDao.deleteWebsitePriviledge(developerId, websiteId, "read");
					privDao.deleteWebsitePriviledge(developerId, websiteId, "update");
				}
				else if(Role.getValue(roleId).toString().equals("reviewer")) {
					privDao.deleteWebsitePriviledge(developerId, websiteId, "read");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	@Override
	public void deletePageRole(int developerId, int pageId, int roleId) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String deletePageRole="Delete from page_role" + 
					" where page_id=? and developer_id=? and role = ?;\r\n" ; 
					
			System.out.println(deletePageRole);
				PreparedStatement pStatement = connection.prepareStatement(deletePageRole);
				pStatement.setInt(1,pageId);
				pStatement.setInt(2,developerId);
				System.out.println(Role.getValue(roleId).toString());
				pStatement.setString(3,Role.getValue(roleId).toString());
				
				pStatement.executeUpdate();

				if(Role.getValue(roleId).toString().equals("admin")||Role.getValue(roleId).toString().equals("owner")) {
					privDao.deletePagePriviledge(developerId, pageId,"create");
					privDao.deletePagePriviledge(developerId, pageId, "read");
					privDao.deletePagePriviledge(developerId, pageId, "update");
					privDao.deletePagePriviledge(developerId, pageId, "delete");
				}
				else if(Role.getValue(roleId).toString().equals("writer")) {
					privDao.deletePagePriviledge(developerId, pageId, "create");
					privDao.deletePagePriviledge(developerId, pageId, "read");
					privDao.deletePagePriviledge(developerId, pageId, "update");
				}
				else if(Role.getValue(roleId).toString().equals("editor")) {
					privDao.deletePagePriviledge(developerId, pageId, "read");
					privDao.deletePagePriviledge(developerId, pageId, "update");
				}
				else if(Role.getValue(roleId).toString().equals("reviewer")) {
					privDao.deletePagePriviledge(developerId, pageId, "read");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

}

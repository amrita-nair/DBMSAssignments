package edu.northeastern.cs5200.daos;

import java.sql.Connection;
import java.sql.Date;
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
import edu.northeastern.cs5200.models.Website;

public class WebsiteDao implements WebsiteImpl{
	
	Statement statement = null;
	ResultSet results = null;
	
	private static WebsiteDao instance = null;

	private WebsiteDao() {
	}
	public static WebsiteDao getInstance() {
		if (instance == null) {
			instance = new WebsiteDao();
		}
		return instance;
	}


	@Override
	public void createWebsiteForDeveloper(int developerId, Website website) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		//Developer(developerKey,int pId,String firstName, String lastName);
		int id = website.getWebsiteId();
		String websiteName = website.getWebsiteName();
		String description = website.getDescription();
		Date createdDate = website.getCreatedDate();
		Date updatedDate = website.getUpdatedDate();
		long visits=website.getVisits();
		
		try {
			Statement s1 = connection.createStatement();
			
			String createWebsiteForDeveloper = "Insert into website VALUES\r\n" + 
					"("+id+",\r\n" + 
					"\""+websiteName +"\",\r\n" + 
					"\""+description+"\",\r\n" + 
					"\'"+createdDate+"\',\r\n" + 
					"\'"+updatedDate+"\',\r\n" + 
					""+visits+",\r\n" + 
					developerId+");\r\n" ;
			System.out.println(createWebsiteForDeveloper);
		   	s1.executeUpdate(createWebsiteForDeveloper);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public Collection<Website> findAllWebsites() {
		List<Website> websites= new ArrayList<Website>();
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findAllWebsites="select * from website\r\n;";
	
			Statement s1 = connection.createStatement();
			results = s1.executeQuery(findAllWebsites);
			
			while(results.next()) {
				int id= results.getInt("website_id");
				String websiteName = results.getString("website_name");
				String description = results.getString("description");
				Date createdDate = results.getDate("created");
				Date updatedDate = results.getDate("updated");
				long visits = results.getLong("visits");
				int ownerDevId= results.getInt("developer_Id");
				
				Website website=new Website(id,  websiteName,  description,  createdDate,  updatedDate,  visits,
						ownerDevId);
				websites.add(website);
				//s1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return websites;
	}
	@Override
	public Collection<Website> findWebsitesForDeveloper(int developerId) {
		List<Website> websites= new ArrayList<Website>();
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findWebsitesForDeveloper="select * from website where developer_id=?;";
	
		PreparedStatement pStatement = connection.prepareStatement(findWebsitesForDeveloper);
		pStatement.setInt(1,developerId);
		results = pStatement.executeQuery();
			if(results.next()) {
				int id= results.getInt("website_id");
				String websiteName = results.getString("website_name");
				String description = results.getString("description");
				Date createdDate = results.getDate("created");
				Date updatedDate = results.getDate("updated");
				long visits = results.getLong("visits");
				int ownerDevId= results.getInt("developer_Id");
				
				Website website=new Website(id,  websiteName,  description,  createdDate,  updatedDate,  visits,
						ownerDevId);
				websites.add(website);
				//s1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return websites;
	}
	@Override
	public Website findWebsiteById(int websiteId) {
		Website website= null;
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findWebsitesForDeveloper="select * from website where website_id=?;";
	
		PreparedStatement pStatement = connection.prepareStatement(findWebsitesForDeveloper);
		pStatement.setInt(1,websiteId);
		results = pStatement.executeQuery();
			if(results.next()) {
				int id= results.getInt("website_id");
				String websiteName = results.getString("website_name");
				String description = results.getString("description");
				Date createdDate = results.getDate("created");
				Date updatedDate = results.getDate("updated");
				long visits = results.getLong("visits");
				int ownerDevId= results.getInt("developer_Id");
				
				website=new Website(id,  websiteName,  description,  createdDate,  updatedDate,  visits,
						ownerDevId);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return website;
	}
	
	public Website findWebsiteByName(String websiteName) {
		Website website= null;
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findWebsiteByName="select * from website where website_name=?;";
	
		PreparedStatement pStatement = connection.prepareStatement(findWebsiteByName);
		pStatement.setString(1,websiteName);
		results = pStatement.executeQuery();
			if(results.next()) {
				int id= results.getInt("website_id");
				
				String description = results.getString("description");
				Date createdDate = results.getDate("created");
				Date updatedDate = results.getDate("updated");
				long visits = results.getLong("visits");
				int ownerDevId= results.getInt("developer_Id");
				
				website=new Website(id,  websiteName,  description,  createdDate,  updatedDate,  visits,
						ownerDevId);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return website;
	}
	
	@Override
	public int updateWebsite(int websiteId, Website website) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String updateWebsite= 	"Update website set \r\n" + 
					"`website_name`=\""+website.getWebsiteName()+"\",\r\n" + 
					"`description`=\""+website.getDescription()+"\",\r\n" +
					"`updated`=\'"+website.getUpdatedDate()+"\',\r\n" +
					"`created`=\'"+website.getCreatedDate()+"\',\r\n" +
					"`visits`="+website.getVisits()+",\r\n" +
					"`developer_id`="+website.getDeveloper_id()+"\r\n" +
					"where website_id= ?;\r\n" ; 
					
			System.out.println(updateWebsite);
				PreparedStatement pStatement = connection.prepareStatement(updateWebsite);
				pStatement.setInt(1,websiteId);
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
	public int deleteWebsite(int websiteId) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String deleteWebsite="Delete from website" + 
					" where website_id=?;\r\n" ; 
					
			System.out.println(deleteWebsite);
				PreparedStatement pStatement = connection.prepareStatement(deleteWebsite);
				pStatement.setInt(1,websiteId);
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
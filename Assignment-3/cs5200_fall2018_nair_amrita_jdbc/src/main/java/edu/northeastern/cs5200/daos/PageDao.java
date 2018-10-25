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

import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Website;

public class PageDao implements PageImpl {
	
	Statement statement = null;
	ResultSet results = null;

	private static PageDao instance = null;

	private PageDao() {
	}
	public static PageDao getInstance() {
		if (instance == null) {
			instance = new PageDao();
		}
		return instance;
	}

	@Override
	public void createPageForWebsite(int websiteId, Page page) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		//Developer(developerKey,int pId,String firstName, String lastName);
		int id = page.getPageId();
		//int wId=page.getWebsiteId();
		String title = page.getTitle();
		String pageDescription = page.getDescription();
		Date createdDate = page.getCreatedDate();
		Date updatedDate = page.getUpdatedDate();
		long views=page.getViews();
		
		
		try {
			Statement s1 = connection.createStatement();
			
			String createPageForWebsite = "Insert into page VALUES\r\n" + 
					"("+id+",\r\n" + 
					+websiteId+",\r\n" +
					"\""+title +"\",\r\n" + 
					"\""+pageDescription+"\",\r\n" + 
					"\'"+createdDate+"\',\r\n" + 
					"\'"+updatedDate+"\',\r\n" + 
					""+views+"\r\n" + 
					");\r\n" ;
			System.out.println(createPageForWebsite);
		   	s1.executeUpdate(createPageForWebsite);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Collection<Page> findAllPages() {
		List<Page> pages= new ArrayList<Page>();
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findAllPages="select * from page\r\n;";
	
			Statement s1 = connection.createStatement();
			results = s1.executeQuery(findAllPages);
			
			while(results.next()) {
				int id= results.getInt("page_id");
				int wId= results.getInt("website_id");
				String title = results.getString("title");
				String description = results.getString("page_description");
				Date createdDate = results.getDate("created");
				Date updatedDate = results.getDate("updated");
				long views = results.getLong("views");
				
				
				Page page=new Page(id, title ,  description,  createdDate,  updatedDate,  views, wId);
				pages.add(page);
				//s1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
	}

	@Override
	public Page findPageById(int pageId) {
		Page page=null;
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findPageById="select * from page where page_id=?;";
	
		PreparedStatement pStatement = connection.prepareStatement(findPageById);
		pStatement.setInt(1,pageId);
		results = pStatement.executeQuery();
			if(results.next()) {
				int id= results.getInt("page_id");
				int wId= results.getInt("website_id");
				String title = results.getString("title");
				String description = results.getString("page_description");
				Date createdDate = results.getDate("created");
				Date updatedDate = results.getDate("updated");
				long views = results.getLong("views");
				
				
				page=new Page(id, title ,  description,  createdDate,  updatedDate,  views, wId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return page;
	}

	@Override
	public List<Page> findPagesForWebsite(int websiteId) {
		List<Page> pages= new ArrayList<Page>();
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findPagesForWebsite="select * from page where website_id = ?;";
		System.out.println(findPagesForWebsite);
			
		PreparedStatement pStatement = connection.prepareStatement(findPagesForWebsite);
		pStatement.setInt(1,websiteId);
		results = pStatement.executeQuery();
			
			while(results.next()) {
				int id= results.getInt("page_id");
				int wId= results.getInt("website_id");
				String title = results.getString("title");
				String description = results.getString("page_description");
				Date createdDate = results.getDate("created");
				Date updatedDate = results.getDate("updated");
				long views = results.getLong("views");
				
				
				Page page=new Page(id, title ,  description,  createdDate,  updatedDate,  views, wId);
				pages.add(page);
				//s1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pages;
	}
	
	public int updatePageTitleCNET(String toBeAppended) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			List<Page> p= new ArrayList<Page>();
			p =findPagesForWebsite(567);
			for(Page page:p) {
			String updatePageTitleCNET= 	"Update page set \r\n" + 
					"`title`=\""+toBeAppended+page.getTitle()+"\"\r\n" + 
					"where `page_id`="+page.getPageId()+";\r\n" ; 
					
			System.out.println(updatePageTitleCNET);
				PreparedStatement pStatement = connection.prepareStatement(updatePageTitleCNET);
			
				//pStatement.setString(2,password);
				pStatement.executeUpdate();
			}	
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public int updatePage(int pageId, Page page) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String updatePage= 	"Update page set \r\n" + 
					"`title`=\""+page.getTitle()+"\",\r\n" + 
					"`page_description`=\""+page.getDescription()+"\",\r\n" +
					"`updated`=\'"+page.getUpdatedDate()+"\',\r\n" +
					"`created`=\'"+page.getCreatedDate()+"\',\r\n" +
					"`views`="+page.getViews()+",\r\n" +
					"`website_id`="+page.getWebsiteId()+"\r\n" +
					"where page_id= ?;\r\n" ; 
					
			System.out.println(updatePage);
				PreparedStatement pStatement = connection.prepareStatement(updatePage);
				pStatement.setInt(1,pageId);
				//pStatement.setString(2,password);
				pStatement.executeUpdate();
				
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
	}
	
	public int removelastUpdatedWikiPage() {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			 String lastUpdated ="select max(updated) from page where page.website_id=345;";
			
			
			
			 PreparedStatement pStatement = connection.prepareStatement(lastUpdated);
				
				results = pStatement.executeQuery();
				if(results.next()) {
					Date last= results.getDate("max(updated)");
					
					String deleteLastContactWidget="delete from page where `updated`='"+last+"' and `website_id`= 345\r\n;" ;
							 
					System.out.println(deleteLastContactWidget);
					PreparedStatement pStatement1 = connection.prepareStatement(deleteLastContactWidget);
					
					//pStatement.setString(2,password);
					pStatement1.executeUpdate();
				}
				return 1;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
	}

	@Override
	public int deletePage(int pageId) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String deletePage="Delete from page" + 
					" where page_id=?;\r\n" ; 
					
			System.out.println(deletePage);
				PreparedStatement pStatement = connection.prepareStatement(deletePage);
				pStatement.setInt(1,pageId);
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

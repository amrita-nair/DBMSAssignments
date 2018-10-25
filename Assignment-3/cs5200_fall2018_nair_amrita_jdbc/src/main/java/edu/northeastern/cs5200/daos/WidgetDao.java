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
import edu.northeastern.cs5200.models.Widget;

public class WidgetDao implements WidgetImpl{


	Statement statement = null;
	ResultSet results = null;

	private static WidgetDao instance = null;

	private WidgetDao() {
	}
	public static WidgetDao getInstance() {
		if (instance == null) {
			instance = new WidgetDao();
		}
		return instance;
	}
	
	@Override
	public void createWidgetForPage(int pageId, Widget widget) {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		//Developer(developerKey,int pId,String firstName, String lastName);
		int id = widget.getWidgetId();
		String widgetName = widget.getWidgetName();
		String cssClass = widget.getCssClass();
		String url = widget.getUrl();
		String text = widget.getText();
		String width=widget.getWidth();
		String height=widget.getHeight();
		int order=widget.getOrder();
	//	int pageId=widget.getPageId();
		
		
		try {
			Statement s1 = connection.createStatement();
			
			String createWidgetForPage = "Insert into widget\r\n" + 
					"(`widget_id`,`widget_name`,`css_class`,`text`,`width`,`height`,`order`,`url`,`page_id`) VALUES\r\n" + 
					"("+id+",\r\n" + 
					"\""+widgetName +"\",\r\n" + 
					"\""+cssClass+"\",\r\n" + 
					"\""+text+"\",\r\n" + 
					"\""+width+"\",\r\n" + 
					"\""+height+"\",\r\n" + 
					""+order+",\r\n" + 
					"\""+url+"\",\r\n"
					+pageId+"\r\n" +
					");\r\n" ;
			System.out.println(createWidgetForPage);
		   	s1.executeUpdate(createWidgetForPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// TODO Auto-generated method stub
		
	}

	@Override
	public Collection<Widget> findAllWidgets() {
		List<Widget> widgets= new ArrayList<Widget>();
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findAllWidgets="select * from widget\r\n;";
	
			Statement s1 = connection.createStatement();
			results = s1.executeQuery(findAllWidgets);
			
			while(results.next()) {
				int id= results.getInt("widget_id");
				int pId= results.getInt("page_id");
				String wName = results.getString("widget_name");
				String cssClass = results.getString("css_class");
				String text = results.getString("text");
				String width = results.getString("width");
				String height = results.getString("height");
				int order = results.getInt("order");
				
				
				Widget widget=new Widget(id, wName , cssClass, text, width, height, order,  pId);
				widgets.add(widget);
				//s1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return widgets;
	}

	@Override
	public Widget findWidgetById(int widgetId) {
		Widget widget=null;
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findWidgetById="select * from widget where widget_id=?;";
	
		PreparedStatement pStatement = connection.prepareStatement(findWidgetById);
		pStatement.setInt(1,widgetId);
		results = pStatement.executeQuery();
			if(results.next()) {
				int id= results.getInt("widget_id");
				int pId= results.getInt("page_id");
				String wName = results.getString("widget_name");
				String cssClass = results.getString("css_class");
				String text = results.getString("text");
				String width = results.getString("width");
				String height = results.getString("height");
				int order = results.getInt("order");
				
				
				widget=new Widget(id, wName , cssClass, text, width, height, order,  pId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return widget;
	}

	@Override
	public List<Widget> findWidgetsForPage(int pageId) {
		List<Widget> widgets= new ArrayList<Widget>();
		try {
		Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		String findWidgetsForPage="select * from widget where page_id = ?;";
		System.out.println(findWidgetsForPage);
			
		PreparedStatement pStatement = connection.prepareStatement(findWidgetsForPage);
		pStatement.setInt(1,pageId);
		results = pStatement.executeQuery();
			
			while(results.next()) {
				int id= results.getInt("widget_id");
				int pId= results.getInt("page_id");
				String wName = results.getString("widget_name");
				String cssClass = results.getString("css_class");
				String text = results.getString("text");
				String width = results.getString("width");
				String height = results.getString("height");
				int order = results.getInt("order");
				
				
				Widget widget=new Widget(id, wName , cssClass, text, width, height, order,  pId);
				widgets.add(widget);
				//s1.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return widgets;
	}

	@Override
	public int updateWidget(int widgetId, Widget widget) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String updateWidget= 	"Update widget set \r\n" + 
					"`widget_name`=\""+widget.getWidgetName()+"\",\r\n" + 
					"`text`="+widget.getText()+",\r\n" + 
					"`width`="+widget.getWidth()+",\r\n" +
					"`height`="+widget.getHeight()+",\r\n" +
					"`order`="+widget.getOrder()+",\r\n" +
					"`page_id`="+widget.getPageId()+"\r\n" +
					"where page_id= ?;\r\n" ; 
					
			System.out.println(updateWidget);
				PreparedStatement pStatement = connection.prepareStatement(updateWidget);
				pStatement.setInt(1,widgetId);
				//pStatement.setString(2,password);
				pStatement.executeUpdate();
				
				return 1;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 0;
	}

	
	public int updateRelativeOrderContact(int pageId) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			List<Widget> widgets= findWidgetsForPage(345);
			for(Widget w: widgets) {
				int maxOrder= widgets.size();
				int currentOrder = w.getOrder();
				int updatedOrder=currentOrder+2;
				int id=w.getWidgetId();
				if(updatedOrder > maxOrder) {
					updatedOrder=updatedOrder-maxOrder;
				//	w.setOrder(updatedOrder);
				}
			
			
			String updateRelativeOrderContact= 	"Update widget set \r\n" + 
					
					"`order`="+updatedOrder+"\r\n" +
					"where `page_id`= ? and `order`=? and `widget_id`=?;\r\n" ; 
					
			System.out.println(updateRelativeOrderContact);
				PreparedStatement pStatement = connection.prepareStatement(updateRelativeOrderContact);
				pStatement.setInt(1,pageId);
				pStatement.setInt(2,currentOrder);
				pStatement.setInt(3,id);
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
	
	public int deleteLastContactWidget() {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String selectWidget= "select max(widget.order) from widget where  page_id=( select page_id from page where title='Contact')";
			PreparedStatement pStatement = connection.prepareStatement(selectWidget);
			
			results = pStatement.executeQuery();
			if(results.next()) {
				int maxOrder= results.getInt("max(widget.order)");
				String deleteLastContactWidget="Delete from widget" + 
						" where `page_id`=345 and `order` ="+ maxOrder +";\r\n" ; 
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
	public int deleteWidget(int widgetId) {
		try {
			Connection connection = edu.northeastern.cs5200.Connection.getConnection();
			
			String deleteWidget="Delete from widget" + 
					" where widget_id=?;\r\n" ; 
					
			System.out.println(deleteWidget);
				PreparedStatement pStatement = connection.prepareStatement(deleteWidget);
				pStatement.setInt(1,widgetId);
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

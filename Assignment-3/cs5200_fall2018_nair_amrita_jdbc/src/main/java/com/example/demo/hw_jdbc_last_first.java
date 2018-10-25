package com.example.demo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.northeastern.cs5200.daos.DeveloperDao;
import edu.northeastern.cs5200.daos.PageDao;
import edu.northeastern.cs5200.daos.RoleDao;
import edu.northeastern.cs5200.daos.UserDao;
import edu.northeastern.cs5200.daos.WebsiteDao;
import edu.northeastern.cs5200.daos.WidgetDao;
import edu.northeastern.cs5200.models.Address;
import edu.northeastern.cs5200.Connection;
import edu.northeastern.cs5200.models.Developer;
import edu.northeastern.cs5200.models.Page;
import edu.northeastern.cs5200.models.Phone;
import edu.northeastern.cs5200.models.User;
import edu.northeastern.cs5200.models.Website;
import edu.northeastern.cs5200.models.Widget;

@SpringBootApplication
public class hw_jdbc_last_first {
	public static void main(String[] args) {
		java.sql.Connection connection = edu.northeastern.cs5200.Connection.getConnection();
		SpringApplication.run(hw_jdbc_last_first.class, args);
		DeveloperDao devDao=DeveloperDao.getInstance();
		UserDao userDao=UserDao.getInstance();
		WebsiteDao websiteDao=WebsiteDao.getInstance();
		PageDao pageDao=PageDao.getInstance();
		WidgetDao widgetDao=WidgetDao.getInstance();
		RoleDao roleDao=RoleDao.getInstance();
		

//		*******************************************Developer and User Insertion************************************************/		
		Phone phone1=new Phone(12,"123-234-3456",true);
		Phone phone2=new Phone(12,"234-345-4566",false);	
		Phone phone3=new Phone(23,"345-456-5677",true);
		Phone phone4=new Phone(34,"432-432-5433",false);
		Phone phone5=new Phone(34,"321-432-5435",true);
		Phone phone6=new Phone(34,"543-543-6544",false);
		
		ArrayList<Phone> phones1=new ArrayList();
		phones1.add(phone1);
		phones1.add(phone2);
		ArrayList<Phone> phones2=new ArrayList();
		phones2.add(phone3);
		ArrayList<Phone> phones3=new ArrayList();
		phones3.add(phone4);
		phones3.add(phone5);
		phones3.add(phone6);
		
		
		Address address1=new Address(12,"123 Adam St.","Alton",null,"01234",true);
		Address address2=new Address(12,"234 Birch St.","Boston",null,"02345",false);
		Address address3=new Address(23,"345 Charles St","Chelms",null,"03455",true);
		Address address4=new Address(23,"456 Down St.","Dalton",null,"04566",false);
		Address address5=new Address(23,"543 East St.","Everett",null,"01112",false);
		Address address6=new Address(34,"Frank St.","Foulton",null,"04322",true);
		
		ArrayList<Address> addressList1=new ArrayList();
		ArrayList<Address> addressList2=new ArrayList();
		ArrayList<Address> addressList3=new ArrayList();
		addressList1.add(address1);
		addressList1.add(address2);
		addressList2.add(address3);
		addressList2.add(address4);
		addressList2.add(address5);
		addressList3.add(address6);
		
		Developer developer1=new Developer("4321rewq",12,"Alice","Wonder","alice","alice","alice@wonder.com",null,addressList1,phones1);
		
		Developer developer2=new Developer("5432trew",23,"Bob","Marley","bob","bob","bob@marley.com",null,addressList2,phones2);
		
		Developer developer3=new Developer("6543ytre",34,"Charles","Garcia","charlie","charlie","chuch@garcia.com",null,addressList3,phones3);
		
		User user1=new User(45,"Dan","Martin","dan","dan","dan@martin.com",null);
		
		User user2=new User(56,"Ed","Karaz","ed","ed","ed@kar.com",null);
		userDao.createUser(user1);
		userDao.createUser(user2);
		devDao.createDeveloper(developer1);
		devDao.createDeveloper(developer2);
		devDao.createDeveloper(developer3);
		
//*******************************************Website Insertion************************************************//	
		
		
		Calendar calendar = Calendar.getInstance();
		java.util.Date utilDate = new java.util.Date();
		Date updated = new Date(utilDate.getTime());
		Date created=new Date(utilDate.getTime());
		Website website1=new Website(123,"Facebook","an online social media and social networking service",created,updated,1234234,12);
		Website website2=new Website(234,"Twitter","an online news and social networking service",created,updated,4321543,23);
		Website website3=new Website(345,"Wikipedia","a free online encyclopedia",created,updated,3456654,34);
		Website website4=new Website(456,"CNN","an American basic cable and satellite television news channel",created,updated,6543345,12);
		Website website5=new Website(567,"CNET","an American media website that publishes reviews, news, articles, blogs, podcasts and videos on chnology and consumer electronics",created,updated,5433455,23);
		Website website6=new Website(678,"Gizmodo","a design, technology, science and science fiction website that also writes articles on litics",created,updated,4322345,34);
		websiteDao.createWebsiteForDeveloper(12,website1);
		websiteDao.createWebsiteForDeveloper(23,website2);
		websiteDao.createWebsiteForDeveloper(34,website3);
		websiteDao.createWebsiteForDeveloper(12,website4);
		websiteDao.createWebsiteForDeveloper(23,website5);
		websiteDao.createWebsiteForDeveloper(34,website6);
		
		
		
//*********************************************Page Insertion*******************************************************//

	
		Page page1=new Page(123,"Home","Landing page",created,updated,1234234,567);
		Page page2=new Page(234,"About","Website description",created,updated,234545,678);
		Page page3=new Page(345,"Contact","Addresses, phones, and contact info",created,updated,345656,345);
		Page page4=new Page(456,"Preferences","Where users can configure their preferences",created,updated,456776,456);
		Page page5=new Page(567,"Profile","Users can configure their personal information",created,updated,567878,567);
		pageDao.createPageForWebsite(567, page1);
		pageDao.createPageForWebsite(678, page2);
		pageDao.createPageForWebsite(345, page3);
		pageDao.createPageForWebsite(456, page4);
		pageDao.createPageForWebsite(567, page5);
	
//*********************************************Widgets Insertion*******************************************************//		

		
		Widget widget1=new Widget(123, "head123", "Welcome","null", "null", 0,"null", 123,"heading");
		Widget widget2=new Widget(234, "post234", "<p>Lorem</p>","null", "null", 0, "null", 234,"html");
		Widget widget3=new Widget(345, "head345", "Hi","null", "null", 1,"null", 345,"heading");
		Widget widget4=new Widget(456, "intro456", "<h1>Hi</h1>","null", "null", 2,"null", 345,"html");
		Widget widget5=new Widget(567, "image 345", "null","50", "100", 3,"/img/567.png", 345,"image");
		Widget widget6=new Widget(678, "video 456", "null","400", "300", 0, "https://youtu.be/h67VX51QXiQ", 456,"youtube");
		widgetDao.createWidgetForPage(123, widget1);
		widgetDao.createWidgetForPage(234, widget2);
		widgetDao.createWidgetForPage(345, widget3);
		widgetDao.createWidgetForPage(345, widget4);
		widgetDao.createWidgetForPage(345, widget5);
		widgetDao.createWidgetForPage(456, widget6);
		
//*********************************************Website Roles and Privileges Insertion*******************************************************//		


		roleDao.assignWebsiteRole(12, 123, 1);
		roleDao.assignWebsiteRole(23, 123, 4);
		roleDao.assignWebsiteRole(34, 123, 2);
		roleDao.assignWebsiteRole(23, 234, 1);
		roleDao.assignWebsiteRole(34, 234, 4);		
		roleDao.assignWebsiteRole(12, 234, 2);
		roleDao.assignWebsiteRole(34, 345, 1);
		roleDao.assignWebsiteRole(12, 345, 4);
		roleDao.assignWebsiteRole(23, 345, 2);
		roleDao.assignWebsiteRole(12, 456, 1);
		roleDao.assignWebsiteRole(23, 456, 4);
		roleDao.assignWebsiteRole(34, 456, 2);
		roleDao.assignWebsiteRole(23, 567, 1);
		roleDao.assignWebsiteRole(34, 567, 4);
		roleDao.assignWebsiteRole(12, 567, 2);
		roleDao.assignWebsiteRole(34, 678, 1);
		roleDao.assignWebsiteRole(12, 678, 4);
		roleDao.assignWebsiteRole(23, 678, 2);
		
		
//*********************************************Page Roles and Privileges Insertion*******************************************************//		
		roleDao.assignPageRole(12, 123, 4);
		roleDao.assignPageRole(23, 123, 5);
		roleDao.assignPageRole(34, 123, 3);
		roleDao.assignPageRole(23, 234, 4);
		roleDao.assignPageRole(34, 234, 5);
		roleDao.assignPageRole(12, 234, 3);
		roleDao.assignPageRole(34, 345, 4);
		roleDao.assignPageRole(12, 345, 5);
		roleDao.assignPageRole(23, 345, 3);
		roleDao.assignPageRole(12, 456, 4);
		roleDao.assignPageRole(23, 456, 5);
		roleDao.assignPageRole(34, 456, 3);
		roleDao.assignPageRole(23, 567, 4);
		roleDao.assignPageRole(34, 567, 5);
		roleDao.assignPageRole(12, 567, 3);
		
		//Update developer - Update Charlie's primary phone number to 333-444-5555
		
		Phone p= new Phone(34,"333-444-5555",true);
		devDao.updatePrimaryPhone(p.getId(), p);
		
		//Update widget - Update the relative order of widget head345 on the page so that it's new order is 3. Note that the other widget's order needs to update as well

		widgetDao.updateRelativeOrderContact(345);
	
		//Update page - Append 'CNET - ' to the beginning of all CNET's page titles

		pageDao.updatePageTitleCNET("CNET - ");
		
		//Update roles - Swap Charlie's and Bob's role in CNET's Home page
		
		List<Page> pages=pageDao.findPagesForWebsite(567);
		for(Page i: pages) {
			roleDao.swapRolesCNET(i.getPageId(),34,23);
		}
		
		//Delete developer - Delete Alice's primary address
		Developer d= devDao.findDeveloperByUsername("alice");
		devDao.deletePrimaryAddress(d.getpId());
		
		//Delete widget - Remove the last widget in the Contact page. The last widget is the one with the highest value in the order field
		widgetDao.deleteLastContactWidget();
		
		//Delete page - Remove the last updated page in Wikipedia
		pageDao.removelastUpdatedWikiPage();
		
		Website w= websiteDao.findWebsiteByName("Wikipedia");
		websiteDao.deleteWebsite(w.getWebsiteId());
		
		//roleDao.deleteWebsiteRole(12, 123, 1);
		//roleDao.deletePageRole(12, 123, 3);
		edu.northeastern.cs5200.Connection.closeConnection(connection);
	}

}

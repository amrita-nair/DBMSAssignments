package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.ArrayList;

public class Website {
	private int websiteId;
	private String websiteName;
	private String description;
	private Date createdDate;
	private Date updatedDate;
	private long visits;
	private ArrayList<Page> pages;
	private int developer_id;
	
	
	
	public Website(int websiteId, String websiteName, String description, Date date, Date date2,
			long visits, int developer_id) {
		super();
		this.websiteId = websiteId;
		this.websiteName = websiteName;
		this.description = description;
		this.createdDate = date;
		this.updatedDate = date2;
		this.visits = visits;
		this.developer_id = developer_id;
	}

	public Website(int websiteId, String websiteName, String description, Date createdDate, Date updatedDate,
			int visits, ArrayList<Page> pages, int developer_id) {
		super();
		this.websiteId = websiteId;
		this.websiteName = websiteName;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.visits = visits;
		this.pages = pages;
		this.developer_id = developer_id;
	}

	public int getWebsiteId() {
		return websiteId;
	}

	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public long getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

	public ArrayList<Page> getPages() {
		return pages;
	}

	public void setPages(ArrayList<Page> pages) {
		this.pages = pages;
	}

	public int getDeveloper_id() {
		return developer_id;
	}

	public void setDeveloper_id(int developer_id) {
		this.developer_id = developer_id;
	}
	
	
	
	
}

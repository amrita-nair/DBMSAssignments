package edu.northeastern.cs5200.models;

import java.sql.Date;
import java.util.ArrayList;

public class Page {
	private int pageId;
	private String title;
	private String description;
	private Date createdDate;
	private Date updatedDate;
	private long views;
	private int websiteId;
	private ArrayList<Widget> widgets;
	
	public Page(int pageId, String title, String description, Date createdDate, Date updatedDate, long views,
			int websiteId) {
		super();
		this.pageId = pageId;
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.views = views;
		this.websiteId = websiteId;
	}
	public Page(int pageId, String title, String description, Date createdDate, Date updatedDate, long views,
			int websiteId, ArrayList<Widget> widgets) {
		super();
		this.pageId = pageId;
		this.title = title;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.views = views;
		this.websiteId = websiteId;
		this.widgets = widgets;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public long getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getWebsiteId() {
		return websiteId;
	}
	public void setWebsiteId(int websiteId) {
		this.websiteId = websiteId;
	}
	public ArrayList<Widget> getWidgets() {
		return widgets;
	}
	public void setWidgets(ArrayList<Widget> widgets) {
		this.widgets = widgets;
	}
	
	
}

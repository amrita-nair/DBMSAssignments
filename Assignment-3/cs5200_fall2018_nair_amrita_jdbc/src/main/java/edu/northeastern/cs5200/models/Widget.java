package edu.northeastern.cs5200.models;

public class Widget {
	private int widgetId;
	private String widgetName;
	private String cssClass;
	
	private String text;
	private String width;
	private String height;
	private int order;
	private int pageId;
	private String dType;
	private String url;
	
	public Widget(int widgetId, String widgetName, String text, String width, String height, int order, int pageId,
			String dType, String url) {
		super();
		this.widgetId = widgetId;
		this.widgetName = widgetName;
		this.text = text;
		this.width = width;
		this.height = height;
		this.order = order;
		this.pageId = pageId;
		this.dType = dType;
		this.url = url;
	}


	public Widget(int widgetId, String widgetName, String text, String width, String height, int order, String url, int pageId,
			String dType) {
		super();
		this.widgetId = widgetId;
		this.widgetName = widgetName;
		this.text = text;
		this.width = width;
		this.height = height;
		this.url=url;
		this.order = order;
		this.pageId = pageId;
		this.dType = dType;
	}
	
	public Widget(int widgetId, String widgetName, String text, int order, int pageId,
			String dType) {
		super();
		this.widgetId = widgetId;
		this.widgetName = widgetName;
		this.text = text;
		this.order = order;
		this.pageId = pageId;
		this.dType = dType;
	}


	public Widget(int widgetId, String widgetName, String cssClass, String text, String width, String height,
			int order, int pageId) {
		super();
		this.widgetId = widgetId;
		this.widgetName = widgetName;
		this.cssClass = cssClass;
	
		this.text = text;
		this.width = width;
		this.height = height;
		this.order = order;
		this.pageId = pageId;
	}
	
	
	public String getdType() {
		return dType;
	}
	public void setdType(String dType) {
		this.dType = dType;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getWidgetId() {
		return widgetId;
	}
	public void setWidgetId(int widgetId) {
		this.widgetId = widgetId;
	}
	public String getWidgetName() {
		return widgetName;
	}
	public void setWidgetName(String widgetName) {
		this.widgetName = widgetName;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public int getPageId() {
		return pageId;
	}
	public void setPageId(int pageId) {
		this.pageId = pageId;
	}
	
	
}

package edu.northeastern.cs5200.models;

public class HeadingWidget extends Widget {
		

	public HeadingWidget(int widgetId, String widgetName, String text, String width, String height, int order, int pageId,
			String dType, String url) {
		super(widgetId, widgetName, text, width, height, order, pageId, dType, url);
		// TODO Auto-generated constructor stub
	}

	

	public HeadingWidget(int widgetId, String widgetName, String text, int order, int pageId, String dType) {
		super(widgetId, widgetName, text, order, pageId, dType);
		// TODO Auto-generated constructor stub
	}



	public HeadingWidget(int widgetId, String widgetName, String text, String width, String height, int order,
			String url, int pageId, String dType) {
		super(widgetId, widgetName, text, width, height, order, url, pageId, dType);
		// TODO Auto-generated constructor stub
	}



	public HeadingWidget(int widgetId, String widgetName, String cssClass, String text, String width, String height,
			int order, int pageId) {
		super(widgetId, widgetName, cssClass, text, width, height, order, pageId);
		// TODO Auto-generated constructor stub
	}



	public HeadingWidget(int widgetId, String widgetName, String text, String width, String height, int order,
			int pageId, String dType, String url, int size) {
		super(widgetId, widgetName, text, width, height, order, pageId, dType, url);
		this.size = size;
	}



	private int size;

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}

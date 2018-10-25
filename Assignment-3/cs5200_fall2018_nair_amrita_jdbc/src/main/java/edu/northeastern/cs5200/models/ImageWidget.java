package edu.northeastern.cs5200.models;

public class ImageWidget extends Widget {
	
	private String src;
 


public ImageWidget(int widgetId, String widgetName, String text, int order, int pageId, String dType) {
		super(widgetId, widgetName, text, order, pageId, dType);
		// TODO Auto-generated constructor stub
	}

	public ImageWidget(int widgetId, String widgetName, String text, String width, String height, int order, int pageId,
			String dType, String url) {
		super(widgetId, widgetName, text, width, height, order, pageId, dType, url);
		// TODO Auto-generated constructor stub
	}

	public ImageWidget(int widgetId, String widgetName, String text, String width, String height, int order, String url,
			int pageId, String dType) {
		super(widgetId, widgetName, text, width, height, order, url, pageId, dType);
		// TODO Auto-generated constructor stub
	}

	public ImageWidget(int widgetId, String widgetName, String cssClass, String text, String width, String height,
			int order, int pageId) {
		super(widgetId, widgetName, cssClass, text, width, height, order, pageId);
		// TODO Auto-generated constructor stub
	}

public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}


}

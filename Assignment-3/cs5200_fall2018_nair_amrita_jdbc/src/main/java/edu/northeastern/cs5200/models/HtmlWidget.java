package edu.northeastern.cs5200.models;

public class HtmlWidget extends Widget {


public HtmlWidget(int widgetId, String widgetName, String text, int order, int pageId, String dType) {
		super(widgetId, widgetName, text, order, pageId, dType);
		// TODO Auto-generated constructor stub
	}

	public HtmlWidget(int widgetId, String widgetName, String text, String width, String height, int order, int pageId,
			String dType, String url) {
		super(widgetId, widgetName, text, width, height, order, pageId, dType, url);
		// TODO Auto-generated constructor stub
	}

	public HtmlWidget(int widgetId, String widgetName, String text, String width, String height, int order, String url,
			int pageId, String dType) {
		super(widgetId, widgetName, text, width, height, order, url, pageId, dType);
		// TODO Auto-generated constructor stub
	}

	public HtmlWidget(int widgetId, String widgetName, String cssClass, String text, String width, String height,
			int order, int pageId) {
		super(widgetId, widgetName, cssClass, text, width, height, order, pageId);
		// TODO Auto-generated constructor stub
	}

private String html;

public String getHtml() {
	return html;
}

public void setHtml(String html) {
	this.html = html;
}
 
}

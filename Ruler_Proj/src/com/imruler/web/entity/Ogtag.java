package com.imruler.web.entity;

public class Ogtag {
	String sitetitle;
	String sitetxt;
	String siteurl;
	
	public Ogtag(String sitetitle, String sitetxt, String siteurl) {
		super();
		this.sitetitle = sitetitle;
		this.sitetxt = sitetxt;
		this.siteurl = siteurl;
	}
	public String getSitetitle() {
		return sitetitle;
	}
	public void setSitetitle(String sitetitle) {
		this.sitetitle = sitetitle;
	}
	public String getSitetxt() {
		return sitetxt;
	}
	public void setSitetxt(String sitetxt) {
		this.sitetxt = sitetxt;
	}
	public String getSiteurl() {
		return siteurl;
	}
	public void setSiteurl(String siteurl) {
		this.siteurl = siteurl;
	}
	
}

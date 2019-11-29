package com.imruler.web.entity;

import java.sql.Date;

public class TradeBoard {
    private int id;
    private String title;
    private String content;
    private String tag;
    private int hit;
    private Date regdate;
    private String user_id;
    private String type;
    
    
    public TradeBoard() {
		
	}

//  for inserting
	public TradeBoard(String title, String content, String tag, String user_id) {
		this.title = title;
		this.content = content;
		this.tag = tag;
		this.user_id = user_id;
	}

//	for selecting
	public TradeBoard(int id, String title, String content, String tag, int hit, Date regdate, String user_id) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.tag = tag;
		this.hit = hit;
		this.regdate = regdate;
		this.user_id = user_id;
	}
	
	

	public TradeBoard(int id, String title, Date regdate, String user_id, int hit, String type) {
	this.id = id;
	this.title = title;
	this.regdate = regdate;
	this.user_id = user_id;
	this.hit = hit;
	this.type = type;
}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TradeBoard [id=" + id + ", title=" + title + ", content=" + content + ", tag=" + tag + ", hit=" + hit
				+ ", regdate=" + regdate + ", user_id=" + user_id + ", type=" + type + "]";
	}


}

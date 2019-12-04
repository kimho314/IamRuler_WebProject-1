package com.imruler.web.entity;

import java.sql.Date;

public class TradeBoard {
    private int id;
    private String title;
    private String content;
    private String tag;
    private int hit;
    private Date regdate;
    private int userId;
    private String type;
    
    
    public TradeBoard() {
		
	}
	
//  for inserting
	public TradeBoard(String title, String content, String tag, int userId) {
		this.title = title;
		this.content = content;
		this.tag = tag;
		this.userId = userId;
	}

//	for selecting
	public TradeBoard(int id, String title, String content, String tag, int hit, Date regdate, int userId, String type) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.tag = tag;
		this.hit = hit;
		this.regdate = regdate;
		this.userId = userId;
		this.type = type;
	}
	
	
	// for update
	public TradeBoard(String title, String content, String tag) {
		this.title = title;
		this.content = content;
		this.tag = tag;
	}

	public TradeBoard(int id, String title, String content, String tag, int hit, Date regdate, int userId) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.tag = tag;
		this.hit = hit;
		this.regdate = regdate;
		this.userId = userId;
	}

	// for 내 작성글 
	public TradeBoard(int id, String title, Date regdate, int userId, int hit, String type) {
		this.id = id;
		this.title = title;
		this.regdate = regdate;
		this.userId = userId;
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
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
				+ ", regdate=" + regdate + ", userId=" + userId + ", type=" + type + "]";
	}


}

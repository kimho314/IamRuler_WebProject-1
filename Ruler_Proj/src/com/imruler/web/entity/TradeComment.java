package com.imruler.web.entity;

import java.sql.Date;

public class TradeComment {
	private int cId;
	private String cContent;
	private int cUserId;
	private Date cRegdate;
	private int cBId;
	private int cOpenStatus;
	private String type;
	
	public TradeComment() {
	}
	
	// for 내 작성글
	public TradeComment(int cId, String cContent, int cUserId, Date cRegdate, int cBId, String type) {
		this.cId = cId;
		this.cContent = cContent;
		this.cUserId = cUserId;
		this.cRegdate = cRegdate;
		this.cBId = cBId;
		this.type = type;
	}

	public TradeComment(int cId, String cContent, int cUserId, Date cRegdate, int cBId, int cOpenStatus) {
		this.cId = cId;
		this.cContent = cContent;
		this.cUserId = cUserId;
		this.cRegdate = cRegdate;
		this.cBId = cBId;
		this.cOpenStatus = cOpenStatus;
	}

	public TradeComment(int cId, String cContent, int cUserId, Date cRegdate, int cBId) {
		this.cId = cId;
		this.cContent = cContent;
		this.cUserId = cUserId;
		this.cRegdate = cRegdate;
		this.cBId = cBId;
	}

	
	
	public TradeComment(String cContent, int cUserId, int cBId, int cOpenStatus) {
		this.cContent = cContent;
		this.cUserId = cUserId;
		this.cBId = cBId;
		this.cOpenStatus = cOpenStatus;
	}

	public TradeComment(int cId, String cContent, int cUserId, int cBId, int cOpenStatus) {
		this.cId = cId;
		this.cContent = cContent;
		this.cUserId = cUserId;
		this.cBId = cBId;
		this.cOpenStatus = cOpenStatus;
	}

	public TradeComment(int cId, String cContent, int cUserId, int cBId) {
		this.cId = cId;
		this.cContent = cContent;
		this.cUserId = cUserId;
		this.cBId = cBId;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcContent() {
		return cContent;
	}

	public void setcContent(String cContent) {
		this.cContent = cContent;
	}

	public int getcUserId() {
		return cUserId;
	}

	public void setcUserId(int cUserId) {
		this.cUserId = cUserId;
	}

	public Date getcRegdate() {
		return cRegdate;
	}

	public void setcRegdate(Date cRegdate) {
		this.cRegdate = cRegdate;
	}

	public int getcBId() {
		return cBId;
	}

	public void setcBId(int cBId) {
		this.cBId = cBId;
	}

	public int getcOpenStatus() {
		return cOpenStatus;
	}

	public void setcOpenStatus(int cOpenStatus) {
		this.cOpenStatus = cOpenStatus;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "TradeComment [cId=" + cId + ", cContent=" + cContent + ", cUserId=" + cUserId + ", cRegdate=" + cRegdate
				+ ", cBId=" + cBId + ", cOpenStatus=" + cOpenStatus + ", type=" + type + "]";
	}

	

	

}

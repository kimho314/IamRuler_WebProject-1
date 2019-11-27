package com.imruler.web.entity;

import java.sql.Date;

public class TradeComment {
	private int cId;
	private String cContent;
	private int cUserId;
	private Date cRegdate;
	private int cBId;

	public TradeComment(int cId, String cContent, int cUserId, Date cRegdate, int cBId) {
		this.cId = cId;
		this.cContent = cContent;
		this.cUserId = cUserId;
		this.cRegdate = cRegdate;
		this.cBId = cBId;
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

	@Override
	public String toString() {
		return "TradeComment [cId=" + cId + ", cContent=" + cContent + ", cUserId=" + cUserId + ", cRegdate=" + cRegdate
				+ ", cBId=" + cBId + "]";
	}

}

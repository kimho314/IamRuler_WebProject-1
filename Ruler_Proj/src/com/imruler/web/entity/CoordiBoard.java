package com.imruler.web.entity;

import java.util.Date;

public class CoordiBoard
{
	private int id;
	private int noticeStatus;
	private int hit;
	private Date regdate;
	private int dibs;
	private int userId;

	
	
	public CoordiBoard()
	{	}

	public CoordiBoard(int id, int noticeStatus, int hit, Date regdate, int dibs, int userId)
	{
		this.id = id;
		this.noticeStatus = noticeStatus;
		this.hit = hit;
		this.regdate = regdate;
		this.dibs = dibs;
		this.userId = userId;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	
	public int getNoticeStatus()
	{
		return noticeStatus;
	}

	public void setNoticeStatus(int noticeStatus)
	{
		this.noticeStatus = noticeStatus;
	}

	public int getHit()
	{
		return hit;
	}

	public void setHit(int hit)
	{
		this.hit = hit;
	}

	public Date getRegdate()
	{
		return regdate;
	}

	public void setRegdate(Date regdate)
	{
		this.regdate = regdate;
	}

	public int getDibs()
	{
		return dibs;
	}

	public void setDibs(int dibs)
	{
		this.dibs = dibs;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	
	@Override
	public String toString()
	{
		return "CoordiBoard [id=" + id + ", noticeStatus=" + noticeStatus + ", hit=" + hit + ", regdate=" + regdate
				+ ", dibs=" + dibs + ", userId=" + userId + "]";
	}
	
	
}

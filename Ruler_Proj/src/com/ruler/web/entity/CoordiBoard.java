package com.ruler.web.entity;

import java.util.Date;

public class CoordiBoard
{
	private int id;
	private int noticeNum;
	private int hit;
	private Date regdate;
	private int dibs;
	private int userId;
	private String img;	
	
	
	public CoordiBoard()
	{
		
	}

	public CoordiBoard(int id, int noticeNum, int hit, Date regdate, int dibs, int userId, String img)
	{
		this.id = id;
		this.noticeNum = noticeNum;
		this.hit = hit;
		this.regdate = regdate;
		this.dibs = dibs;
		this.userId = userId;
		this.img = img;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getNoticeNum()
	{
		return noticeNum;
	}

	public void setNoticeNum(int noticeNum)
	{
		this.noticeNum = noticeNum;
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

	public String getImg()
	{
		return img;
	}

	public void setImg(String img)
	{
		this.img = img;
	}

	@Override
	public String toString()
	{
		return "CoordiBoard [id=" + id + ", noticeNum=" + noticeNum + ", hit=" + hit + ", regdate=" + regdate
				+ ", dibs=" + dibs + ", userId=" + userId + ", img=" + img + "]";
	}
	
	
}

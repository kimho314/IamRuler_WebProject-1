package com.imruler.web.entity;

import java.util.Date;

public class CoordiBoardView extends CoordiBoard
{
	private int dibsCount;

	public CoordiBoardView()
	{
		super();
		
	}

	public CoordiBoardView(int id, int noticeNum, int hit, Date regdate, 
			int dibs, int userId, String img, int dibsCount)
	{
		super(id, noticeNum, hit, regdate, dibs, userId, img);		
		this.dibsCount = dibsCount;
	}

	public int getDibsCount()
	{
		return dibsCount;
	}

	public void setDibsCount(int dibsCount)
	{
		this.dibsCount = dibsCount;
	}
	
		
}

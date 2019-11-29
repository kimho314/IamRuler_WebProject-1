package com.imruler.web.entity;

public class CoordiImg
{
	private int id;
	private int coordiId;
	private String img;
	
	public CoordiImg()
	{	}
	
	// for selecting
	public CoordiImg(int id, int coordiId, String img)
	{
		this.id = id;
		this.coordiId = coordiId;
		this.img = img;
	}
	
	// for inserting
	public CoordiImg(int coordiId, String img)
	{
		super();
		this.coordiId = coordiId;
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

	public int getCoordiId()
	{
		return coordiId;
	}

	public void setCoordiId(int coordiId)
	{
		this.coordiId = coordiId;
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
		return "CoordiImg [id=" + id + ", coordiId=" + coordiId + ", img=" + img + "]";
	}
	
	
}

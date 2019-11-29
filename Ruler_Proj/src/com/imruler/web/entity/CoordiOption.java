package com.imruler.web.entity;

public class CoordiOption
{
	private int id;
	private String bodyShape;
	private String gender;
	
	public CoordiOption()
	{	}
	
	// for selecting and inserting
	public CoordiOption(int id, String bodyShape, String gender)
	{
		this.id = id;
		this.bodyShape = bodyShape;
		this.gender = gender;
	}	


	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}

	public String getBodyShape()
	{
		return bodyShape;
	}

	public void setBodyShape(String bodyShape)
	{
		this.bodyShape = bodyShape;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	@Override
	public String toString()
	{
		return "CoordiOption [id=" + id + ", bodyShape=" + bodyShape + ", gender=" + gender + "]";
	}
	
	
}

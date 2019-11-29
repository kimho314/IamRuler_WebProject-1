package com.imruler.web.entity;


public class CoordiContent
{
	private int id;
	private String title;
	private String content;
	private String tag;
	
	public CoordiContent()
	{	}
	
	// for selecting
	public CoordiContent(int id, String title, String content, String tag)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.tag = tag;
	}
	
	// for inserting
	public CoordiContent(String title, String content, String tag)
	{
		super();
		this.title = title;
		this.content = content;
		this.tag = tag;
	}
	

	public int getId()
	{
		return id;
	}


	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public String getTag()
	{
		return tag;
	}

	public void setTag(String tag)
	{
		this.tag = tag;
	}

	@Override
	public String toString()
	{
		return "CoordiContent [id=" + id + ", title=" + title + ", content=" + content + ", tag=" + tag + "]";
	}
	
	
}

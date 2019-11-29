package com.imruler.web.entity;

import java.util.Date;

public class CoordiComment
{
	private int id;
	private String content;
	private int userId;
	private Date regdate;
	private int boardId;
	private int openStat;
	
	public CoordiComment()
	{	}
		
	// for inserting
	public CoordiComment(String content, int userId, int boardId)
	{
		this.content = content;
		this.userId = userId;
		this.boardId = boardId;
	}

	public CoordiComment(String content, int userId, int boardId, int openStat)
	{
		this.content = content;
		this.userId = userId;
		this.boardId = boardId;
		this.openStat = openStat;
	}

	// for selecting
	public CoordiComment(int id, String content, int userId, Date regdate, int boardId, int openStat)
	{
		this.id = id;
		this.content = content;
		this.userId = userId;
		this.regdate = regdate;
		this.boardId = boardId;
		this.openStat = openStat;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getContent()
	{
		return content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	public Date getRegdate()
	{
		return regdate;
	}

	public void setRegdate(Date regdate)
	{
		this.regdate = regdate;
	}

	public int getBoardId()
	{
		return boardId;
	}

	public void setBoardId(int boardId)
	{
		this.boardId = boardId;
	}

	public int getOpenStat()
	{
		return openStat;
	}

	public void setOpenStat(int openStat)
	{
		this.openStat = openStat;
	}

	@Override
	public String toString()
	{
		return "CoordiComment [id=" + id + ", content=" + content + ", userId=" + userId + ", regdate=" + regdate
				+ ", boardId=" + boardId + ", openStat=" + openStat + "]";
	}
	
	
	
}

package com.imruler.web.entity;

import java.util.Date;

public class CoordiCommentView
{
	private int cb_id;
	private int ccmt_openStat;
	private int ccmt_id;
	private String ccmt_content;
	private int ccmt_userId;
	private Date ccmt_regdate;
	private int ccmt_bId;
	private int m_id;
	private String m_userName;
	
	public CoordiCommentView()
	{	}
	
	

	public CoordiCommentView(int cb_id, int ccmt_openStat, int ccmt_id, String ccmt_content, int ccmt_userId,
			Date ccmt_regdate, int ccmt_bId, int m_id, String m_userName)
	{
		this.cb_id = cb_id;
		this.ccmt_openStat = ccmt_openStat;
		this.ccmt_id = ccmt_id;
		this.ccmt_content = ccmt_content;
		this.ccmt_userId = ccmt_userId;
		this.ccmt_regdate = ccmt_regdate;
		this.ccmt_bId = ccmt_bId;
		this.m_id = m_id;
		this.m_userName = m_userName;
	}



	public int getCcmt_openStat()
	{
		return ccmt_openStat;
	}



	public void setCcmt_openStat(int ccmt_openStat)
	{
		this.ccmt_openStat = ccmt_openStat;
	}


	public int getCb_id()
	{
		return cb_id;
	}

	public void setCb_id(int cb_id)
	{
		this.cb_id = cb_id;
	}

	public int getCcmt_id()
	{
		return ccmt_id;
	}

	public void setCcmt_id(int ccmt_id)
	{
		this.ccmt_id = ccmt_id;
	}

	public String getCcmt_content()
	{
		return ccmt_content;
	}

	public void setCcmt_content(String ccmt_content)
	{
		this.ccmt_content = ccmt_content;
	}

	public int getCcmt_userId()
	{
		return ccmt_userId;
	}

	public void setCcmt_userId(int ccmt_userId)
	{
		this.ccmt_userId = ccmt_userId;
	}

	public Date getCcmt_regdate()
	{
		return ccmt_regdate;
	}

	public void setCcmt_regdate(Date ccmt_regdate)
	{
		this.ccmt_regdate = ccmt_regdate;
	}

	public int getCcmt_bId()
	{
		return ccmt_bId;
	}

	public void setCcmt_bId(int ccmt_bId)
	{
		this.ccmt_bId = ccmt_bId;
	}

	public int getM_id()
	{
		return m_id;
	}

	public void setM_id(int m_id)
	{
		this.m_id = m_id;
	}

	public String getM_userName()
	{
		return m_userName;
	}

	public void setM_userName(String m_userName)
	{
		this.m_userName = m_userName;
	}


	@Override
	public String toString()
	{
		return "CoordiCommentView [cb_id=" + cb_id + ", ccmt_openStat=" + ccmt_openStat + ", ccmt_id=" + ccmt_id
				+ ", ccmt_content=" + ccmt_content + ", ccmt_userId=" + ccmt_userId + ", ccmt_regdate=" + ccmt_regdate
				+ ", ccmt_bId=" + ccmt_bId + ", m_id=" + m_id + ", m_userName=" + m_userName + "]";
	}

	
}

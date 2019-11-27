package com.imruler.web.entity;

import java.util.Date;

public class CoordiBoardView
{
	private int m_id;
	private String m_user_name;
	private int cb_id;
	private int cb_notice_stat;
	private int cb_hit;
	private Date cb_regdate;
	private int cb_dibs;
	private String cct_title;
	private String cct_content;
	private String cct_tag;
	private int ci_id;
	private String ci_img;
	private String co_gender;
	private String co_bodyshape;
	private int dl_id;
	private String dl_memo;
	
	public CoordiBoardView()
	{	}
	
	public CoordiBoardView(int m_id, String m_user_name, int cb_id, int cb_notice_stat, int cb_hit, Date cb_regdate,
			int cb_dibs, String cct_title, String cct_content, String cct_tag, int ci_id, String ci_img,
			String co_gender, String co_bodyshape, int dl_id, String dl_memo)
	{
		this.m_id = m_id;
		this.m_user_name = m_user_name;
		this.cb_id = cb_id;
		this.cb_notice_stat = cb_notice_stat;
		this.cb_hit = cb_hit;
		this.cb_regdate = cb_regdate;
		this.cb_dibs = cb_dibs;
		this.cct_title = cct_title;
		this.cct_content = cct_content;
		this.cct_tag = cct_tag;
		this.ci_id = ci_id;
		this.ci_img = ci_img;
		this.co_gender = co_gender;
		this.co_bodyshape = co_bodyshape;
		this.dl_id = dl_id;
		this.dl_memo = dl_memo;
	}

	public int getM_id()
	{
		return m_id;
	}

	public void setM_id(int m_id)
	{
		this.m_id = m_id;
	}

	public String getM_user_name()
	{
		return m_user_name;
	}

	public void setM_user_name(String m_user_name)
	{
		this.m_user_name = m_user_name;
	}

	public int getCb_id()
	{
		return cb_id;
	}

	public void setCb_id(int cb_id)
	{
		this.cb_id = cb_id;
	}

	public int getCb_notice_stat()
	{
		return cb_notice_stat;
	}

	public void setCb_notice_stat(int cb_notice_stat)
	{
		this.cb_notice_stat = cb_notice_stat;
	}

	public int getCb_hit()
	{
		return cb_hit;
	}

	public void setCb_hit(int cb_hit)
	{
		this.cb_hit = cb_hit;
	}

	public Date getCb_regdate()
	{
		return cb_regdate;
	}

	public void setCb_regdate(Date cb_regdate)
	{
		this.cb_regdate = cb_regdate;
	}

	public int getCb_dibs()
	{
		return cb_dibs;
	}

	public void setCb_dibs(int cb_dibs)
	{
		this.cb_dibs = cb_dibs;
	}

	public String getCct_title()
	{
		return cct_title;
	}

	public void setCct_title(String cct_title)
	{
		this.cct_title = cct_title;
	}

	public String getCct_content()
	{
		return cct_content;
	}

	public void setCct_content(String cct_content)
	{
		this.cct_content = cct_content;
	}

	public String getCct_tag()
	{
		return cct_tag;
	}

	public void setCct_tag(String cct_tag)
	{
		this.cct_tag = cct_tag;
	}

	public int getCi_id()
	{
		return ci_id;
	}

	public void setCi_id(int ci_id)
	{
		this.ci_id = ci_id;
	}

	public String getCi_img()
	{
		return ci_img;
	}

	public void setCi_img(String ci_img)
	{
		this.ci_img = ci_img;
	}

	public String getCo_gender()
	{
		return co_gender;
	}

	public void setCo_gender(String co_gender)
	{
		this.co_gender = co_gender;
	}

	public String getCo_bodyshape()
	{
		return co_bodyshape;
	}

	public void setCo_bodyshape(String co_bodyshape)
	{
		this.co_bodyshape = co_bodyshape;
	}

	public int getDl_id()
	{
		return dl_id;
	}

	public void setDl_id(int dl_id)
	{
		this.dl_id = dl_id;
	}

	public String getDl_memo()
	{
		return dl_memo;
	}

	public void setDl_memo(String dl_memo)
	{
		this.dl_memo = dl_memo;
	}

	@Override
	public String toString()
	{
		return "CoordiBoardView [m_id=" + m_id + ", m_user_name=" + m_user_name + ", cb_id=" + cb_id
				+ ", cb_notice_stat=" + cb_notice_stat + ", cb_hit=" + cb_hit + ", cb_regdate=" + cb_regdate
				+ ", cb_dibs=" + cb_dibs + ", cct_title=" + cct_title + ", cct_content=" + cct_content + ", cct_tag="
				+ cct_tag + ", ci_id=" + ci_id + ", ci_img=" + ci_img + ", co_gender=" + co_gender + ", co_bodyshape="
				+ co_bodyshape + ", dl_id=" + dl_id + ", dl_memo=" + dl_memo + "]";
	}
	
	
	

}

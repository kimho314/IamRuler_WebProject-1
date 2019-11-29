package com.imruler.web.controller.coordi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.Dibs;
import com.imruler.web.service.DibsService;
import com.imruler.web.service.mypage.RulerDibsService;

@WebServlet("/coordi/reg_dibs")
public class CoordiDibsListController extends HttpServlet
{
	private DibsService dibsService;

	public CoordiDibsListController()
	{
		// TODO Auto-generated constructor stub
		dibsService = new RulerDibsService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO doGet
		String gender = "";
		String _gender = req.getParameter("g");
		if(_gender != null && !_gender.equals(""))
		{
			gender = _gender;
		}
		
		int m_id = 0;
		String _m_id = req.getParameter("m_id");
		if(_m_id != null && !_m_id.equals(""))
		{
			m_id = Integer.parseInt(_m_id);
		}
		
		int cb_id = 0;
		String _cb_id = req.getParameter("cb_id");
		if(_cb_id != null && !_cb_id.equals(""))
		{
			cb_id = Integer.parseInt(_cb_id);
		}
		
		
		int isDibbed = -1;
		isDibbed = dibsService.getDibsCountByBoardId(cb_id);
		
		if(isDibbed == 0)		
		{
			System.out.println("newly Dibbed");
			int result = dibsService.insertDibs(new Dibs("", m_id, cb_id));
			if(result == 1)
			{
				if(gender.equals("여성"))
					resp.sendRedirect("list_w");
				if(gender.equals("남성"))
					resp.sendRedirect("list_m");
			}
		}
		else
		{
			System.out.println("Dibbed");
			int result = dibsService.deleteDibs(m_id, cb_id);
			if(result == 1)
			{
				if(gender.equals("여성"))
					resp.sendRedirect("list_w");
				if(gender.equals("남성"))
					resp.sendRedirect("list_m");
			}
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO doPost

	}
}

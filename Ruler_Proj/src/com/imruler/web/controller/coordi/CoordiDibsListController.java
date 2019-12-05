package com.imruler.web.controller.coordi;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.Dibs;
import com.imruler.web.entity.DibsView;
import com.imruler.web.entity.Member;
import com.imruler.web.service.DibsService;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;
import com.imruler.web.service.mypage.RulerDibsService;

@WebServlet("/coordi/reg_dibs")
public class CoordiDibsListController extends HttpServlet
{
	private DibsService dibsService;
	private MemberService memberService;

	public CoordiDibsListController()
	{
		// TODO Auto-generated constructor stub
		dibsService = new RulerDibsService();
		memberService = new RulerMemberService();
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
		
		int cb_id = 0;
		String _cb_id = req.getParameter("cb_id");
		if(_cb_id != null && !_cb_id.equals(""))
		{
			cb_id = Integer.parseInt(_cb_id);
		}
		
		int returnOpt = 0;
		String _returnOpt = req.getParameter("returnOpt");
		if(_returnOpt != null && !_returnOpt.equals(""))
		{
			returnOpt = Integer.parseInt(_returnOpt);
		}
		
		String userName = "";
		String _userName = req.getParameter("m_name");
		if(_userName != null && !_userName.equals(""))
		{
			userName = _userName;
		}
		
		int m_id = 0;
		Member member = memberService.get(userName);
		m_id = member.getId();
		
		int isDibbed = 0;
		//isDibbed = dibsService.getDibsCountByBoardId(cb_id);
		List<DibsView> list = new ArrayList<>();
		list = dibsService.getDibsListById(m_id);
		Dibs dibs = null;
		for(DibsView key : list)
		{
			//System.out.println(key.getCoordiId() + ":" + cb_id);
			if(key.getCoordiId() == cb_id)
			{
				dibs = key;
				isDibbed = 1;
				break;
			}
		}
		
		
		int result = 0;
		if(isDibbed == 0)		
		{
			System.out.println("newly Dibbed");
			result = dibsService.insertDibs(new Dibs("", m_id, cb_id));			
		}
		else
		{
			System.out.println("Dibbed");
			result = dibsService.deleteDibs(m_id, cb_id);			
		}
		
		if(result == 1)
		{
			if(returnOpt == 0)
			{
				if(gender.equals("여성"))
					resp.sendRedirect("list_w");
				if(gender.equals("남성"))
					resp.sendRedirect("list_m");
			}
			else if(returnOpt == 1)
			{				
				String genderEncoded = URLEncoder.encode(gender, "UTF-8");	
				resp.sendRedirect("post?cb_id="+cb_id+"&g="+genderEncoded);
			}
			
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO doPost

	}
}

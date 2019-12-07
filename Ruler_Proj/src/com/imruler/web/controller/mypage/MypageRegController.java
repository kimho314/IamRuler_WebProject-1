package com.imruler.web.controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;

@WebServlet("/mypage/reg")
public class MypageRegController extends HttpServlet
{
	private MemberService memberService;

	public MypageRegController()
	{
		memberService = new RulerMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		request.getRequestDispatcher("/WEB-INF/view/mypage/reg.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/* (db) userName값 받아서 pw로 가져오기 start */
		Cookie[] cookie = request.getCookies();
		String userName = null;
		String userPw = "";
		
		if (cookie != null)
			for (Cookie key : cookie)
				if (key.getName().equals("userName"))
					userName = key.getValue();
		
		if (userName == null)
		{
			HttpSession session = request.getSession();
			userName = (String) session.getAttribute("userName");
		}
		
		if (userName != null && !userName.equals(""))
			userPw = memberService.get(userName).getPwd();
		/* (db) userName값 받아서 pw로 가져오기 end */
		int result = 0;
		String inputPw = request.getParameter("pwd");
		if (inputPw != null && !inputPw.equals(""))
			if (userPw.equals(inputPw))
				result = 1;
		
		if (result == 1)
			response.sendRedirect("/mypage/myinfo");
		else
			response.sendRedirect("/mypage/reg?error=1");

	}
}

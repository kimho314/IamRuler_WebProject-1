package com.imruler.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.service.MemberService;
import com.imruler.web.service.RankingService;
import com.imruler.web.service.member.RulerMemberService;
import com.imruler.web.service.ranking.RulerRankingService;

@WebServlet("/rank") // 진행중
public class RankingController extends HttpServlet
{
	private RankingService rankingService;
	private MemberService memberService;

	public RankingController()
	{
		rankingService = new RulerRankingService();
		memberService = new RulerMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/* (db) userName값 받아 start */
		Cookie[] cookie = request.getCookies();
		String userName = null;
		int userId = 1;
		
		if (cookie != null)
			for (Cookie key : cookie)
				if (key.getName().equals("userName"))
					userName = key.getValue();
		
		if (userName == null)
		{
			HttpSession session = request.getSession();
			userName = (String) session.getAttribute("userName");
		}
		/* (db) userName값 받아 end */

		if (userName != null && !userName.equals(""))
			request.setAttribute("userGender", memberService.get(userName).getGender());

		request.getRequestDispatcher("/WEB-INF/view/rank/index.jsp").forward(request, response);
	}
}

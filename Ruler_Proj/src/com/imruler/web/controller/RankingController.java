package com.imruler.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.imruler.web.entity.Ogtag;
import com.imruler.web.entity.Ranking;
import com.imruler.web.service.RankingService;
import com.imruler.web.service.ranking.RulerRankingService;

@WebServlet("/rank") // 진행중
public class RankingController extends HttpServlet{
	private RankingService rankingService;
//	private MemberService memberService;
	public RankingController() {
		rankingService = new RulerRankingService();
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session = request.getSession();
//		Object userId = session.getAttribute("userName");
//		if( userId != null && !userId.equals("")) {// 회원 성별정보
//			 request.setAttribute("userGender",memberService.getGenderById(userId));
//		}
//		else 
		
		String type = request.getParameter("type");
		
		if(type != null && !type.equals("")) {
			switch (type) {
			case "0":
				request.setAttribute("list", rankingService.getRankingList(0));
				break;
			case "1":
				request.setAttribute("list", rankingService.getRankingList(1));
				break;
			}
		}
		else
			request.setAttribute("list", rankingService.getRankingList());//전체리스트
			//request.setAttribute("oglist",getOgList(rankingService.getRankingList()));//리스트
		request.getRequestDispatcher("/WEB-INF/view/rank/index.jsp").forward(request, response);
	}
}

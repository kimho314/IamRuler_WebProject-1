package com.imruler.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.imruler.web.entity.Ranking;
import com.imruler.web.service.RankingService;
import com.imruler.web.service.ranking.RulerRankingService;

@WebServlet("/rank-json") // 진행중
public class RankingJSONController extends HttpServlet{
	private RankingService rankingService;
	public RankingJSONController() {
		rankingService = new RulerRankingService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("type");
		List<Ranking> list = null;
		if(type != null && !type.equals("")) 
			switch (type) {
			case "0":
				list = rankingService.getRankingList(0);
				break;
			case "1":
				list = rankingService.getRankingList(1);
				break;
			}
		else
			list = rankingService.getRankingList();//전체리스트
		
		 Gson gson = new Gson();
		 String json = gson.toJson(list);
		 
		response.setCharacterEncoding("UTF-8"); //작성된 코드의 인코딩방식 설정
		response.setContentType("text/html;charset=UTF-8"); // 브라우저의 응답헤더로 보내짐
		
		PrintWriter out = response.getWriter();
		out.print(json);
		
	}
}

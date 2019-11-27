package com.imruler.web.controller.trade.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.service.TradeService;
import com.imruler.web.service.ruler.RulerTradeService;

@WebServlet("/trade/reg")
public class TradeRegController extends HttpServlet{
	
	private TradeService tradeService;
	
	public TradeRegController() {
		tradeService = new RulerTradeService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/trade/reg.jsp").forward(request, response);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String clothes = request.getParameter("clothes");
		String area = request.getParameter("area");
		String body = request.getParameter("body");
		String complete = request.getParameter("complete");
		String userId = request.getParameter("userId");
		
		HttpSession session = request.getSession(true);
		session.setAttribute(userId, "yupddok");
		
		System.out.println(userId+title+content+clothes+area+body+complete);
		
		response.sendRedirect("/trade/list");
		
		
	}

}

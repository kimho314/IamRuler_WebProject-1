package com.imruler.web.controller.trade.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.service.TradeService;
import com.imruler.web.service.ruler.RulerTradeService;

@WebServlet("/trade/edit")
public class TradeEditController extends HttpServlet{
	
	private TradeService tradeService;
	
	public TradeEditController() {
		tradeService = new RulerTradeService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/trade/edit.jsp").forward(request, response);
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
		
		
		System.out.println(title+content+clothes+area+body+complete);
		
		response.sendRedirect("/trade/list");
	}

}

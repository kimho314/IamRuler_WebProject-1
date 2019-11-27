package com.imruler.web.controller.trade.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.service.TradeService;
import com.imruler.web.service.ruler.RulerTradeService;

@WebServlet("/trade/list")
public class TradeListController extends HttpServlet {
	
	private TradeService tradeService;
	
	@Override
	public void init() throws ServletException {
		tradeService = new RulerTradeService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setAttribute("list", tradeService.getTradeList(page, field, query));
		request.setAttribute("list", tradeService.getTradeList());
		request.getRequestDispatcher("/trade/list.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

	

}

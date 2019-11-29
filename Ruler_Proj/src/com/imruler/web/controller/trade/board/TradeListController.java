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
		
		String area = "";
		String body = "";
		String clothes = "";
		String searchText = "";
		
		String area_ = request.getParameter("area");
		if(area_!=null && !area_.equals(""))
			area=area_;
		String body_ = request.getParameter("body");
		if(body_!=null && !body_.equals(""))
			body=body_;
		String clothes_ = request.getParameter("clothes");
		if(clothes_!=null && !area_.equals(""))
			clothes=clothes_;
		String searchText_ = request.getParameter("q");
		if(searchText_!=null && !searchText_.equals(""))
			searchText=searchText_;
		//System.out.println(area+body+clothes+searchText);
		
		
		
		
		
	}
	

	

}

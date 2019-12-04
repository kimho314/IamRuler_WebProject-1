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

	public TradeListController() {
		tradeService = new RulerTradeService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page=1;
		String field ="title";
		String query ="";
		
		String page_= request.getParameter("p");
		if(page_!=null && !page_.equals(""))
			page=Integer.parseInt(page_);
		
		String field_= request.getParameter("f");
		if(field_!=null && !field_.equals(""))
			field=field_;
		
		String query_= request.getParameter("q");
		if(query_!=null && !query_.equals(""))
			query=query_;
		
		String area = "";
		String body = "";
		String clothes = "";
		String searchText = "";
		
//		String area_ = request.getParameter("area");
//		if(area_!=null && !area_.equals(""))
//			area=area_;
//		String body_ = request.getParameter("body");
//		if(body_!=null && !body_.equals(""))
//			body=body_;
//		String clothes_ = request.getParameter("clothes");
//		if(clothes_!=null && !area_.equals(""))
//			clothes=clothes_;
		String searchText_ = request.getParameter("searchText");
		if(searchText_!=null && !searchText_.equals(""))
			searchText=searchText_;
		System.out.println(area+body+clothes+searchText);
		
		tradeService.getTradeList(page, field, searchText);
		
		request.setAttribute("list", tradeService.getTradeList(page, field, query));
		request.setAttribute("listCount", tradeService.tradeListCount(field, query));
		request.getRequestDispatcher("/WEB-INF/view/trade/list.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		//request.getRequestDispatcher("/trade/list.jsp").forward(request, response);
		
		
		
	}
	

	

}

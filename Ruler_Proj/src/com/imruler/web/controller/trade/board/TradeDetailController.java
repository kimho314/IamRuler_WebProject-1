package com.imruler.web.controller.trade.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.TradeComment;
import com.imruler.web.entity.TradeView;
import com.imruler.web.service.TradeCommentService;

import com.imruler.web.service.TradeViewService;
import com.imruler.web.service.ruler.RulerTradeService;

@WebServlet("/trade/detail")
public class TradeDetailController extends HttpServlet{
	
	// private TradeService tradeService;
	private TradeViewService tradeViewService;
	private TradeCommentService tradeCommentService;
	
	public TradeDetailController() {
		// tradeService = new RulerTradeService();
		tradeViewService = new RulerTradeService();
		tradeCommentService = new RulerTradeService();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String secret = request.getParameter("secret");
		if (secret == null) {
		secret = "0";
		}
		int num = Integer.parseInt(secret);
		TradeView tradeView = tradeViewService.getTrade(id);
		List<TradeView> tradeView2 = tradeViewService.getComment(id);
		//TradeBoard tradeBoard = tradeService.getTrade(id);
		System.out.println("boardid"+id);

		request.setAttribute("t", tradeView);
		request.setAttribute("c", tradeView2);
		
		request.getRequestDispatcher("/trade/detail.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getParameter("cmd");
		String cmdList = request.getParameter("cmdList");
		
		int cId = 1;
		String cId_ = null;
		String cContent = "";
		int cUserId = 1;
		int cBId = 1;
		int cOpenStatus = 1;
		String cOpenStatusString = "";
		System.out.println("CMD"+cmd);
		
		switch(cmd) {
		case "등록":
			cId_ = request.getParameter("cId");
			if(cId_!=null && !cId_.equals(""))
				cId=Integer.parseInt(cId_);
			String cContent_ = request.getParameter("cContent");
			if(cContent_!=null && !cContent_.contentEquals(""))
				cContent=cContent_;
			String cUserId_ = request.getParameter("cUserId");
			if(cUserId_!=null && !cUserId_.equals(""))
				cUserId = Integer.parseInt(cUserId_);
			String cBId_ = request.getParameter("cBId");
			if(cBId_!=null && !cBId_.equals(""))
				cBId=Integer.parseInt(cBId_);
			String cOpenStatus_ = request.getParameter("cOpenStatus");
			if(cOpenStatus_!=null && !cOpenStatus_.equals("")) 
				cOpenStatusString = cOpenStatus_;
			if (cOpenStatusString.equals("on")) {
				cOpenStatus = 1;
			} else {
				cOpenStatus = 0;
			}
				
			
			int result = tradeCommentService.insertTradeComment(new TradeComment(cContent, cUserId, cBId, cOpenStatus));
			System.out.println("cId:"+cId+"cBId:"+cBId+"cContent:"+cContent+"cUserId:"+cUserId+"openStatus"+cOpenStatus);
			System.out.println("result"+result);
			break;
		case "수정":
			//int edit = tradeCommentService.updateTradeComment(new TradeComment(cId, cContent, cUserId, cBId));
			break;
		case "삭제":
			cId_ = request.getParameter("cId");
			if(cId_!=null && !cId_.equals(""))
				cId=Integer.parseInt(cId_);
			System.out.println(cId_);
			System.out.println(cId);
			int del = tradeCommentService.deleteTradeComment(cId);
			System.out.println("cId:"+cId+"삭제됐니"+del);
			break;
		}
		response.sendRedirect("/trade/detail?id="+cBId);
		
		
		

		

	}
}

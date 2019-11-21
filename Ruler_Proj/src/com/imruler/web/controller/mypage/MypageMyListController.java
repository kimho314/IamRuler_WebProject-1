package com.imruler.web.controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.service.TradeService;
import com.imruler.web.service.trade.RulerTradeService;

@WebServlet("/mypage/mylist")
public class MypageMyListController extends HttpServlet{
	TradeService TradeService;
	@Override
	public void init() throws ServletException {
		TradeService = new RulerTradeService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
//		request.setAttribute("boardList", TradeService.getBoardListById(session.getAttribute("userId"))); //내가 쓴 게시글
//		request.setAttribute("cmtList", TradeService.getCommentListById(session.getAttribute("userId"))); //내가 쓴 댓글

		
		request.getRequestDispatcher("/WEB-INF/view/mypage/myBoardList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
}

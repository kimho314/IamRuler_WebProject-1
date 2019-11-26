package com.imruler.web.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.service.DibsService;
import com.imruler.web.service.mypage.RulerDibsService;

@WebServlet("/mypage/index")
public class MypageMainController extends HttpServlet{
	DibsService dibsService;
	@Override
	public void init() throws ServletException {
		dibsService = new RulerDibsService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * HttpSession session = request.getSession(); int userId = 0; Object userId_ =
		 * session.getAttribute("userName"); if(userId_ != null && !userId_.equals(""))
		 * userId = Integer.parseInt(String.valueOf(userId_));
		 */
		int userId = 1;
//		request.setAttribute("boardList", TradeService.getBoardListById(userId)); //내가 쓴 게시글
//		request.setAttribute("cmtList", TradeService.getCommentListById(userId)); //내가 쓴 댓글
		request.setAttribute("zzimList", dibsService.getDibsListById(userId)); //찜목록 
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/index.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
}

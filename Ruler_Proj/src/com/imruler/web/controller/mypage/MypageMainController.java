package com.imruler.web.controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mypage/index")
public class MypageMainController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		request.setAttribute("boardList", TradeService.getBoardListById(userId)); //내가 쓴 게시글
//		request.setAttribute("cmtList", TradeService.getCommentListById(userId)); //내가 쓴 댓글
//		request.setAttribute("zzimList", zzimList); //찜목록 
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/index.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
}

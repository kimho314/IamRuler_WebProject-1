package com.imruler.web.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.dao.TradeBoardDao;
import com.imruler.web.dao.TradeCommentDao;
import com.imruler.web.dao.jdbc.JdbcMemberDao;
import com.imruler.web.dao.jdbc.JdbcTradeBoardDao;
import com.imruler.web.dao.jdbc.JdbcTradeCommentDao;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;


@WebServlet("/mypage/mylist")
public class MypageMyListController extends HttpServlet{
	TradeBoardDao tradeBoardDao;
	TradeCommentDao tradeCommentDao;
	MemberService memberService;
	
	@Override
	public void init() throws ServletException {
		tradeBoardDao = new JdbcTradeBoardDao(); 
		tradeCommentDao = new JdbcTradeCommentDao();
		memberService = new RulerMemberService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* (db) userName값 받아서 id로 가져오기 start */
		Cookie[] cookie = request.getCookies();
	      String userName = null;
	      int userId=1;
	      if (cookie != null)
	    	 for (Cookie key : cookie)
		            if(key.getName().equals("userName"))
		            	userName = key.getValue();	      
	      if (userName == null) {
	    	 HttpSession session = request.getSession();
	    	 userName = (String) session.getAttribute("userName");
	      }
	      if( userName != null && !userName.equals(""))
			userId = memberService.get(userName).getId();
	      /* (db) userName값 받아서 id로 가져오기 end */
		
		int page = 1;
		String page_ = request.getParameter("p");
		if(page_ != null && !page_.equals(""))
			page = Integer.parseInt(page_);
		
		String type = "";
		String type_ = request.getParameter("t");
		if(page_ != null && !page_.equals(""))
			type = type_;
		
		//System.out.println(page);
		if(type.equals("b")) {
			request.setAttribute("boardList", tradeBoardDao.getListByUserId(userId,page));
			request.setAttribute("cmtList", tradeCommentDao.getCommentListByUserId(userId,1));
		}
		else if(type.equals("c")) {
			request.setAttribute("boardList", tradeBoardDao.getListByUserId(userId,1));
			request.setAttribute("cmtList", tradeCommentDao.getCommentListByUserId(userId,page));
		}
		else {
			request.setAttribute("boardList", tradeBoardDao.getListByUserId(userId,1));
			request.setAttribute("cmtList", tradeCommentDao.getCommentListByUserId(userId,1));
		} 
		
		request.setAttribute("bListCount", tradeBoardDao.getListCountByUserId(userId));
		request.setAttribute("cListCount", tradeCommentDao.getCommentListCountByUserId(userId));
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/myBoardList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
}

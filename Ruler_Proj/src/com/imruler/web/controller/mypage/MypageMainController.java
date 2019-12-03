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
import com.imruler.web.dao.jdbc.JdbcTradeBoardDao;
import com.imruler.web.dao.jdbc.JdbcTradeCommentDao;
import com.imruler.web.service.DibsService;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;
import com.imruler.web.service.mypage.RulerDibsService;

@WebServlet("/mypage/index")
public class MypageMainController extends HttpServlet{
	DibsService dibsService;
	MemberService memberService;
	TradeBoardDao tradeBoardDao;
	TradeCommentDao tradeCommentDao;
	
	public MypageMainController() {
		tradeBoardDao = new JdbcTradeBoardDao(); 
		tradeCommentDao = new JdbcTradeCommentDao();
		dibsService = new RulerDibsService();
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

		request.setAttribute("boardList", tradeBoardDao.getListByUserId(userId, 1)); //내가 쓴 게시글
		request.setAttribute("cmtList", tradeCommentDao.getCommentListByUserId(userId, 1)); //내가 쓴 댓글
		request.setAttribute("zzimList", dibsService.getDibsListById(userId)); //찜목록 
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/index.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
}

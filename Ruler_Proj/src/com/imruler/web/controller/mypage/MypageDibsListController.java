package com.imruler.web.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.imruler.web.entity.Dibs;
import com.imruler.web.service.DibsService;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;
import com.imruler.web.service.mypage.RulerDibsService;

@WebServlet("/mypage/myzzim")
public class MypageDibsListController extends HttpServlet{
	DibsService dibsService;
	MemberService memberService;
	
	@Override
	public void init() throws ServletException {
		dibsService = new RulerDibsService();
		memberService = new RulerMemberService();		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		Cookie c1 = new Cookie("del","");
		response.addCookie(c1);
		
		request.setAttribute("list",dibsService.getDibsListById(userId));
		request.getRequestDispatcher("/WEB-INF/view/mypage/myZzimList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	      
		String list = request.getParameter("list");
		
		if(list != null && !list.equals("")) {
			int updateResult = 0;
			JsonParser jsonParser = new JsonParser();
			JsonArray jsonArr = (JsonArray) jsonParser.parse(list);
			for (int i = 0; i < jsonArr.size(); i++) {
				JsonObject object = (JsonObject) jsonArr.get(i);
				int dibsId = object.get("dibsId").getAsInt();
				String memo = object.get("memo").getAsString();
				//System.out.println("dibsId : "+dibsId+", memo : "+memo);
				updateResult += dibsService.updateDibs(new Dibs(dibsId,memo));
			}
		}
		String del_ = request.getParameter("del");
		//System.out.println(del_);
		if(del_ != null && !del_.equals("")) {
			int delResult = 0;
			int del = 0;
			del = Integer.parseInt(del_);
			//System.out.println(del);
			delResult = dibsService.deleteDibs(userId,del);
			
			//System.out.println(delResult);
			Cookie[] cookies = request.getCookies();
			Cookie delCookie = null;
			for (Cookie c : cookies) 
				if(c.getName().equals("del"))
					 delCookie = c;	
			
			if(delResult == 1) {
				delCookie.setValue("1");
				response.addCookie(delCookie);
			}
			else {
				delCookie.setValue("2");
				response.addCookie(delCookie);
			}
				
			response.sendRedirect("/mypage/myzzim");
		}
	}
	
}

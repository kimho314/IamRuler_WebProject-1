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

@WebServlet("/mypage/myzzim")
public class MypageDibsListController extends HttpServlet{
	DibsService dibsService;
	@Override
	public void init() throws ServletException {
		dibsService = new RulerDibsService();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session  = request.getSession();
		String userId = null;
		Object userId_ = session.getAttribute("userName");
		if(userId_ != null && userId_.equals(""))
			userId = String.valueOf(userId_);
		
		request.setAttribute("list",dibsService.getDibsListById(userId));
		request.getRequestDispatcher("/WEB-INF/view/mypage/myZzimList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}
}

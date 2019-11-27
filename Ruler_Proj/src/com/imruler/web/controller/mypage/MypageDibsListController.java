package com.imruler.web.controller.mypage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.Dibs;
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
//		HttpSession session  = request.getSession();
//		int userId = 0;
//		Object userId_ = session.getAttribute("userName");
//		if(userId_ != null && !userId_.equals(""))
//			userId = Integer.parseInt((String) userId_);
		int userId = 1;

		request.setAttribute("list",dibsService.getDibsListById(userId));
		
		request.getRequestDispatcher("/WEB-INF/view/mypage/myZzimList.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		HttpSession session  = request.getSession();
//		int userId = 0;
//		Object userId_ = session.getAttribute("userName");
//		if(userId_ != null && !userId_.equals(""))
//			userId = Integer.parseInt((String) userId_);

//		String list = request.getParameter("list");
//		//String memo[] = request.getParameterValues("memo");
//		if(list != null)
//			System.out.println(list);
//		else
//			System.out.print(" list: null");

		//if(list != null)
			
			/*for (int i = 0; i < list.length; i++) {
			System.out.println(list[i]);
		}*/
		
		int userId = 1;
//		String[] memo = request.getParameterValues("memo");
//		String[] coordiId_ = request.getParameterValues("coordiId");
//		int[] coordiId = null;
//		for (int i = 0; i < coordiId_.length; i++) 
//			coordiId[i] = Integer.parseInt(coordiId_[i]);
		
//		int result=0;
//			//result = dibsService.insertDibs(new Dibs("가나다라",1,10)); 정상동작
//			result = dibsService.updateDibs(new Dibs(1,"가나다라"));
//			if(result==1)
		int result = 0;
		int del = 0;
		Object del_ = request.getParameter("del");
		if(del_ != null && !del_.equals("")) {
			del = Integer.parseInt(String.valueOf(del_));
			System.out.println(del);
			result = dibsService.deleteDibs(userId,del);
			if(result == 1) 
				request.setAttribute("del",1);
			
			else
				request.setAttribute("del",2);
			
			request.setAttribute("list",dibsService.getDibsListById(userId));
			request.getRequestDispatcher("/WEB-INF/view/mypage/myZzimList.jsp").forward(request, response);
		}
		else 
			response.sendRedirect("/mypage/myzzim");
	}
	
}

package com.imruler.web.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;

@WebServlet("/mypage/withdraw")
public class MypageWithdrawController extends HttpServlet {
	private MemberService memberService;

	public MypageWithdrawController() {
		// TODO Auto-generated constructor stub
		memberService = new RulerMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/view/mypage/withdraw.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userName");
		String userPwd = request.getParameter("password");
		if (userPwd.equals(memberService.get(userId).getPwd()) || memberService.get(userId).getPwd() == null) {
			memberService.deleteMember(memberService.get(userId).getId());
			response.sendRedirect("/index");
		} else {
			response.sendRedirect("withdraw?error=1"); // 비밀번호가 틀릴경우
		}
	}
}

package com.imruler.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.service.member.RulerMemberService;

@WebServlet("/sign/login")
public class LoginController extends HttpServlet {
	RulerMemberService rulerMemberService;

	public LoginController() {
		rulerMemberService = new RulerMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO doGet
		String returnUrl = req.getParameter("returnUrl");

		req.setAttribute("returnUrl", returnUrl);
		req.getRequestDispatcher("/WEB-INF/view/sign/login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO doPost
		String userId = req.getParameter("아이디");
		String userPwd = req.getParameter("비밀번호");
		String returnUrl = req.getParameter("returnUrl");

		boolean isVaild = rulerMemberService.isValidMember(userId, userPwd);

		if (!isVaild) {
			resp.sendRedirect("login?error=1");
		} else {
			req.getSession().setAttribute("userName", userId);
			if (returnUrl != null && !returnUrl.equals("")) {
				resp.sendRedirect(returnUrl);
			} else {
				resp.sendRedirect("/index");
			}
		}
	}
}

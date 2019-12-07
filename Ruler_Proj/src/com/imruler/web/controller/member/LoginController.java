package com.imruler.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;

@WebServlet("/sign/login")
public class LoginController extends HttpServlet {
	MemberService memberService;

	public LoginController() {
		memberService = new RulerMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO doGet
		String returnUrl = req.getParameter("returnUrl");

		req.setAttribute("returnUrl", returnUrl);
		req.getRequestDispatcher("/WEB-INF/view/sign/login.jsp").forward(req, resp);
//		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO doPost
		String userId = req.getParameter("아이디");
		String userPwd = req.getParameter("비밀번호");
		String returnUrl = req.getParameter("returnUrl");
		

		boolean isVaild = memberService.isValidMember(userId, userPwd);

		if (!isVaild) {
			resp.sendRedirect("login?error=1");
		} else {
			cookie(req, resp, userId);
			req.getSession().setAttribute("userName", userId);
			System.out.println("로그인됬나?");
			if (returnUrl != null && !returnUrl.equals("")) {
				resp.sendRedirect(returnUrl);
			} else {
				resp.sendRedirect("/index");
			}
		}
	}
	
	public void cookie(HttpServletRequest req, HttpServletResponse resp, String userId) throws IOException {
		Cookie cookie = new Cookie("userName", userId);
		cookie.setPath("/");
		
		resp.addCookie(cookie);
	}
}

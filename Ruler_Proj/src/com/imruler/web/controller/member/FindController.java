package com.imruler.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.internal.StringUtil;

import com.imruler.web.entity.Member;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;

@WebServlet("/sign/find")
public class FindController extends HttpServlet {
	private MemberService memberService;

	public FindController() {
		memberService = new RulerMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO doGet
		req.getRequestDispatcher("/WEB-INF/view/sign/find.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO doPost
		int btn = 0;
		if (req.getParameter("찾기").equals("아이디찾기")) {
			btn = 1;
		} else if (req.getParameter("찾기").equals("비밀번호찾기")) {
			btn = 2;
		}
		
		String email = req.getParameter("email");
		String userId = req.getParameter("userId");
		String phone = req.getParameter("phone");

		if (email != null && btn == 1) {
			String userIdFind = memberService.idFinder(email);
			req.setAttribute("id", userIdFind);
			req.getRequestDispatcher("/WEB-INF/view/sign/find.jsp?r=1").forward(req, resp);
		} else if (userId != null && phone != null && btn == 2) {
			String userPwdFind = memberService.pwdFinder(userId, phone);
			req.setAttribute("pwd", userPwdFind);
			btn = 0;
			req.getRequestDispatcher("/WEB-INF/view/sign/find.jsp?r=2").forward(req, resp);
		} else {
			resp.sendRedirect("find?r=0");
		}
	}
}

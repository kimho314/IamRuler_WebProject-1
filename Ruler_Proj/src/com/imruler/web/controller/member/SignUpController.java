package com.imruler.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.Member;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;

@WebServlet("/sign/sign-up")
public class SignUpController extends HttpServlet {
	private MemberService memberService;

	public SignUpController() {
		memberService = new RulerMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO doGet
		req.getRequestDispatcher("/WEB-INF/view/sign/sign-up.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO doPost
		String userId = req.getParameter("아이디");
		String userPwd = req.getParameter("비밀번호");
		String userPwdRequest = req.getParameter("비밀번호확인");
		String phone = req.getParameter("전화번호");
		String email = req.getParameter("이메일1") + "@" + req.getParameter("이메일2");
		int height = Integer.parseInt(req.getParameter("키"));
		int weidth = Integer.parseInt(req.getParameter("체중"));
		String gender = req.getParameter("성별");
		int age = Integer.parseInt(req.getParameter("연령대"));
		String bodyshape = req.getParameter("체형");

//		String signUpError = null;

		boolean isDuplicated = memberService.isDuplicatedId(userId, userPwd, userPwdRequest, phone, email);
		
		if (!isDuplicated) {
			resp.sendRedirect("sign-up?error=1");
		} else {
			memberService.insertMember(new Member(userId, userPwd, phone, email, height, weidth, gender, age, bodyshape));
			resp.sendRedirect("/index");
		}
	}
}

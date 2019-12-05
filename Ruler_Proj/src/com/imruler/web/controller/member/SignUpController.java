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
		if (!req.getParameter("아이디").equals("") && !req.getParameter("비밀번호").equals("")
				&& !req.getParameter("비밀번호확인").equals("") && !req.getParameter("전화번호").equals("")
				&& !req.getParameter("이메일1").equals("") && !req.getParameter("이메일2").equals("")
				&& !req.getParameter("키").equals("") && !req.getParameter("체중").equals("")) {
			String userId = req.getParameter("아이디");
			String userPwd = req.getParameter("비밀번호");
			String userPwdRequest = req.getParameter("비밀번호확인");
			String phone = "";
			if (req.getParameter("전화번호").length() == 11) {
				phone = req.getParameter("전화번호").substring(0, 3) + "-" + req.getParameter("전화번호").substring(3, 7) + "-"
						+ req.getParameter("전화번호").substring(7, 11);
			}
			String email = req.getParameter("이메일1") + "@" + req.getParameter("이메일2");
			int height = Integer.parseInt(req.getParameter("키"));
			int weidth = Integer.parseInt(req.getParameter("체중"));
			String gender = req.getParameter("성별");
			int age = Integer.parseInt(req.getParameter("연령대"));
			String bodyshape = req.getParameter("체형");

			int isDuplicated = memberService.isDuplicatedId(userId, userPwd, userPwdRequest, phone, email); // 에러확인 1차
			if (StringUtil.isNumeric(req.getParameter("전화번호")) == false) { // 전화번호가 숫자만 들어가있는지 확인
				isDuplicated = 3;
				System.out.println("전화번호 오류");
			}

			if (isDuplicated != 0) { // 에러 확인값이 0이 아닐경우 에러
				resp.sendRedirect("sign-up?error=" + isDuplicated); // 에러 발생시 해당하는 코드값으로 이동
			} else {
				memberService.insertMember(
						new Member(userId, userPwd, phone, email, height, weidth, gender, age, bodyshape)); // 회원가입시
																											// 정보입력
				if (memberService.get(userId) != null) {
					resp.sendRedirect("sign-up?result=1");
				} else {
					System.out.println("회원가입실패");
					resp.sendRedirect("sign-up?error=0"); // 회원가입실패
				}
			}
		} else {
			System.out.println("알수없는 에러");
			resp.sendRedirect("sign-up?error=0"); // 알수없는 에러
		}
	}
}

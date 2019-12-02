package com.imruler.web.controller.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.entity.Member;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;

@WebServlet("/mypage/myinfo")
public class MypageMyinfoController extends HttpServlet {
	private MemberService memberService;

	public MypageMyinfoController() {
		// TODO Auto-generated constructor stub
		memberService = new RulerMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Cookie[] cookie = request.getCookies();
		String cValue = null;
		String userId = null;
		String age = null;
		String height = null;
		String weight = null;
		if (cookie != null) {
			for (Cookie key : cookie) {
				Cookie c = key;
				cValue = c.getValue();
			}
		}

		userId = cValue;
		if (userId == null) {
			userId = (String) session.getAttribute("userName");
		}

		if (userId != null) {
			age = String.valueOf(memberService.get(userId).getAge());
			height = String.valueOf(memberService.get(userId).getHeight());
			weight = String.valueOf(memberService.get(userId).getWeight());

			System.out.println(memberService.get(userId).getGender());

			request.setAttribute("userId", userId); // 아이디
			request.setAttribute("gender", memberService.get(userId).getGender()); // 성별
			request.setAttribute("age", age); // 연령대
			request.setAttribute("phone", memberService.get(userId).getPhone()); // 휴대폰번호
			request.setAttribute("email", memberService.get(userId).getEmail()); // 이메일
			request.setAttribute("height", height); // 키
			request.setAttribute("weight", weight); // 몸무게
			request.setAttribute("bodyshape", memberService.get(userId).getBodyshape()); // 몸무게
			request.getRequestDispatcher("/WEB-INF/view/mypage/myinfo.jsp").forward(request, response);
		} else {
			response.sendRedirect("/index");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Cookie[] cookie = req.getCookies();
		String cValue = null;
		String userId = null;
		if (cookie != null) {
			for (Cookie key : cookie) {
				Cookie c = key;
				cValue = c.getValue();
			}
		}

		userId = cValue;
		if (userId == null) {
			userId = (String) session.getAttribute("userName");
		}

		if (userId != null) {
			if (!req.getParameter("비밀번호").equals("") && !req.getParameter("비밀번호확인").equals("")
					&& !req.getParameter("전화번호").equals("") && !req.getParameter("이메일").equals("")
					&& !req.getParameter("키").equals("") && !req.getParameter("체중").equals("")) {
				String userPwd = req.getParameter("비밀번호");
				String userPwdRequest = req.getParameter("비밀번호확인");
				String phone = req.getParameter("전화번호");
				String email = req.getParameter("이메일");
				int height = Integer.parseInt(req.getParameter("키"));
				int weidth = Integer.parseInt(req.getParameter("체중"));
				String gender = req.getParameter("성별");
				int age = Integer.parseInt(req.getParameter("연령대"));
				String bodyshape = req.getParameter("체형");
				
				memberService.myInfoDeleteMember(memberService.get(userId).getId());
				
				int isDuplicated = memberService.isDuplicatedIdMyInfo(userId, userPwd, userPwdRequest, phone, email);

				if (isDuplicated != 0) {
					resp.sendRedirect("myinfo?error=" + isDuplicated);
				} else {
					memberService.updateMember(
							new Member(userId, userPwd, phone, email, height, weidth, gender, age, bodyshape));
					resp.sendRedirect("/index");
				}
			} else {
				resp.sendRedirect("myinfo?error=0");
			}
		}
	}
}

package com.imruler.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.dao.IndexDao;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.member.RulerMemberService;
import com.imruler.web.service.ruler.RulerIndexService;

@WebServlet("/index")
public class IndexController extends HttpServlet {
	private MemberService memberService;
	private IndexDao indexDao;

	public IndexController() {
		memberService = new RulerMemberService();
		indexDao = new RulerIndexService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookie = request.getCookies();
		HttpSession session = request.getSession();
		if (cookie != null || session.getAttribute("userName") != null) {
			String cValue = null;
			
			System.out.println(cookie);
			System.out.println(session.getAttribute("userName"));
			
			if (cookie != null) {
				for (Cookie key : cookie) {
					Cookie c = key;
					cValue = c.getValue();
				}
			}
			
			System.out.println(cValue);
			String userId = null;
			userId = cValue;

			if (userId.equals(null)) {
				userId = (String) session.getAttribute("userName");
			}
			if (memberService.get(userId) != null) {
				request.setAttribute("userAge", memberService.get(userId).getAge());
				System.out.println( memberService.get(userId).getAge());
				request.setAttribute("userBodyshape", memberService.get(userId).getBodyshape());
				request.setAttribute("userGender", memberService.get(userId).getGender());
				request.setAttribute("userHeight", memberService.get(userId).getHeight());
				request.setAttribute("userWeight", memberService.get(userId).getWeight());
			}
		}

		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int x = 0, y = 0;
		String bodyshape = "", gender = "";
		String type = "";

		int shoulderWidth = 0; // 어깨너비
		int chestBreadth = 0; // 가슴단면
		int waistWidth = 0; // 허리단면
		int sleeveLength = 0; // 소매길이
		int crotchWidth = 0; // 밑위길이
		int thighWidth = 0;// 허벅지 단면
		int hemWidth = 0;// 밑단 단면
		int skirtHemWidth = 0; // 치마 밑단 단면
		int topTotalLength = 0; // 상의 총장
		int pantsTotalLength = 0; // 바지 총장
		int skirtTotalLength = 0; // 치마 총장
		int onePieceTotalLength = 0; // 원피스 총장

		String type_ = request.getParameter("type");
		if (type_ != null && !type_.equals(""))
			type = type_;

		String x_ = request.getParameter("x");
		String y_ = request.getParameter("y");
		String gender_ = request.getParameter("gender");
		String bodyshape_ = request.getParameter("bodyshape");

		String shoulderWidth1_ = request.getParameter("tshoulderWidth");
		String shoulderWidth2_ = request.getParameter("oshoulderWidth");
		String shoulderWidth3_ = request.getParameter("opshoulderWidth");
		if (type.equals("T") && shoulderWidth1_ != null && !shoulderWidth1_.equals(""))
			shoulderWidth = Integer.parseInt(shoulderWidth1_);
		if (type.equals("O") && shoulderWidth2_ != null && !shoulderWidth2_.equals(""))
			shoulderWidth = Integer.parseInt(shoulderWidth2_);
		if (type.equals("Op") && shoulderWidth3_ != null && !shoulderWidth3_.equals(""))
			shoulderWidth = Integer.parseInt(shoulderWidth3_);

		String chestBreadth1_ = request.getParameter("tchestBreadth");
		String chestBreadth2_ = request.getParameter("ochestBreadth");
		String chestBreadth3_ = request.getParameter("opchestBreadth");
		if (type.equals("T") && chestBreadth1_ != null && !chestBreadth1_.equals(""))
			chestBreadth = Integer.parseInt(chestBreadth1_);
		if (type.equals("O") && chestBreadth2_ != null && !chestBreadth2_.equals(""))
			chestBreadth = Integer.parseInt(chestBreadth2_);
		if (type.equals("Op") && chestBreadth3_ != null && !chestBreadth3_.equals(""))
			chestBreadth = Integer.parseInt(chestBreadth3_);

		String sleeveLength1_ = request.getParameter("tsleeveLength");
		String sleeveLength2_ = request.getParameter("osleeveLength");
		String sleeveLength3_ = request.getParameter("opsleeveLength");
		if (type.equals("T") && sleeveLength1_ != null && !sleeveLength1_.equals(""))
			sleeveLength = Integer.parseInt(sleeveLength1_);
		if (type.equals("O") && sleeveLength2_ != null && !sleeveLength2_.equals(""))
			sleeveLength = Integer.parseInt(sleeveLength2_);
		if (type.equals("Op") && sleeveLength3_ != null && !sleeveLength3_.equals(""))
			sleeveLength = Integer.parseInt(sleeveLength3_);

		String topTotalLength1_ = request.getParameter("ttopTotalLength");
		String topTotalLength2_ = request.getParameter("otopTotalLength");
		if (type.equals("T") && topTotalLength1_ != null && !topTotalLength1_.equals(""))
			topTotalLength = Integer.parseInt(topTotalLength1_);
		if (type.equals("O") && topTotalLength2_ != null && !topTotalLength2_.equals(""))
			topTotalLength = Integer.parseInt(topTotalLength2_);

		String waistWidth1_ = request.getParameter("pwaistWidth");
		String waistWidth2_ = request.getParameter("skwaistWidth");
		if (type.equals("P") && waistWidth1_ != null && !waistWidth1_.equals(""))
			waistWidth = Integer.parseInt(waistWidth1_);
		if (type.equals("Sk") && waistWidth2_ != null && !waistWidth2_.equals(""))
			waistWidth = Integer.parseInt(waistWidth2_);

		String crotchWidth_ = request.getParameter("crotchWidth");
		String thighWidth_ = request.getParameter("thighWidth");
		String hemWidth_ = request.getParameter("hemWidth");
		String skirtHemWidth_ = request.getParameter("skirtHemWidth");

		String pantsTotalLength_ = request.getParameter("pantsTotalLength");
		String skirtTotalLength_ = request.getParameter("skirtTotalLength");
		String onePieceTotalLength_ = request.getParameter("onePieceTotalLength");

		if (x_ != null && !x_.equals(""))
			x = Integer.parseInt(x_);
		if (y_ != null && !y_.equals(""))
			y = Integer.parseInt(y_);
		if (gender_ != null && !gender_.equals(""))
			gender = gender_;
		if (bodyshape_ != null && !bodyshape_.equals(""))
			bodyshape = bodyshape_;

		if (crotchWidth_ != null && !crotchWidth_.equals(""))
			crotchWidth = Integer.parseInt(crotchWidth_);
		if (thighWidth_ != null && !thighWidth_.equals(""))
			thighWidth = Integer.parseInt(thighWidth_);
		if (hemWidth_ != null && !hemWidth_.equals(""))
			hemWidth = Integer.parseInt(hemWidth_);
		if (skirtHemWidth_ != null && !skirtHemWidth_.equals(""))
			skirtHemWidth = Integer.parseInt(skirtHemWidth_);
		if (pantsTotalLength_ != null && !pantsTotalLength_.equals(""))
			pantsTotalLength = Integer.parseInt(pantsTotalLength_);
		if (skirtTotalLength_ != null && !skirtTotalLength_.equals(""))
			skirtTotalLength = Integer.parseInt(skirtTotalLength_);
		if (onePieceTotalLength_ != null && !onePieceTotalLength_.equals(""))
			onePieceTotalLength = Integer.parseInt(onePieceTotalLength_);

		System.out.println(type);
		System.out.println(gender);
		System.out.println("비교하러옴");

		int cloth = 0;

		switch (type) {
		case "T":
			cloth = indexDao.top(x, y, gender, bodyshape, shoulderWidth, chestBreadth, sleeveLength, topTotalLength);
			break;
		case "P":
			cloth = indexDao.pants(x, y, gender, bodyshape, waistWidth, thighWidth, crotchWidth, hemWidth,
					pantsTotalLength);
			break;
		case "O":
			cloth = indexDao.outer(x, y, gender, bodyshape, shoulderWidth, chestBreadth, sleeveLength, topTotalLength);
			break;
		case "Sk":
			cloth = indexDao.skirt(x, y, gender, bodyshape, waistWidth, skirtHemWidth, skirtTotalLength);
			break;
		case "Op":
			cloth = indexDao.onePiece(x, y, gender, bodyshape, shoulderWidth, chestBreadth, sleeveLength,
					onePieceTotalLength);
			break;
		}

		request.setAttribute("result", cloth);

		request.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(request, response);

	}
}

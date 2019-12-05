package com.imruler.web.controller.trade.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.imruler.web.entity.Member;
import com.imruler.web.entity.TradeComment;
import com.imruler.web.entity.TradeView;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.TradeCommentService;
import com.imruler.web.service.TradeImgService;
import com.imruler.web.service.TradeItemService;
import com.imruler.web.service.TradeService;
import com.imruler.web.service.TradeViewService;
import com.imruler.web.service.member.RulerMemberService;
import com.imruler.web.service.ruler.RulerTradeImgService;
import com.imruler.web.service.ruler.RulerTradeItemService;
import com.imruler.web.service.ruler.RulerTradeService;

@WebServlet("/trade/detail")
public class TradeDetailController extends HttpServlet {

	private TradeViewService tradeViewService;
	private TradeCommentService tradeCommentService;
	private TradeService tradeService;
	private TradeItemService tradeItemService;
	private TradeImgService tradeImgService;
	private MemberService memberService;

	public TradeDetailController() {
		tradeViewService = new RulerTradeService();
		tradeCommentService = new RulerTradeService();
		tradeService = new RulerTradeService();
		tradeItemService = new RulerTradeItemService();
		tradeImgService = new RulerTradeImgService();
		memberService = new RulerMemberService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Cookie[] cookie = request.getCookies();
		String cValue = null;
		if (cookie != null) {
			for (Cookie key : cookie) {
				Cookie c = key;
				cValue = c.getValue();
				break;
			}
		}
		if (cookie != null) {
			for (Cookie key : cookie) {
				Cookie c = key;
				cValue = c.getValue();
				break;
			}
		}
		HttpSession session = request.getSession();

		String userId = cValue;
		if (userId == null) {
			userId = (String) session.getAttribute("userName");
		}

		int id = Integer.parseInt(request.getParameter("id"));
		String secret = request.getParameter("secret");
		if (secret == null) {
			secret = "0";
		}
		String boardUserName = null;
		int boardUserId = tradeService.getBoardUserId(id);
		if (memberService.get(boardUserId) != null) {
			boardUserName = memberService.get(boardUserId).getUserName();
		}
//		int num = Integer.parseInt(secret);
		TradeView tradeView = tradeViewService.getTrade(id);
		List<TradeView> tradeView2 = tradeViewService.getComment(id);
		//List<TradeBoardView> tradeBoardView = tradeService.getTradeList(id);
		//TradeBoard tradeBoard = tradeService.getTrade(id);
		System.out.println("boardid"+id);

//		String cmd="";
//		String cmd_ = request.getParameter("cmd");
//		if(cmd_!=null && !cmd_.equals(""))
//			 cmd=cmd_;
		
		//request.setAttribute("cmd", cmd);
		request.setAttribute("t", tradeView);
		request.setAttribute("c", tradeView2);
		if (memberService.get(boardUserId) != null) {
		request.setAttribute("boardUserName", boardUserName);
		}

		request.getRequestDispatcher("/WEB-INF/view/trade/detail.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String cmd = request.getParameter("cmd");
		String edel = request.getParameter("edel");

		int cId = 1;
		String cId_ = null;
		String cContent = "";
		int cUserId = 0;
		int cBId = 1;
		int cOpenStatus = 1;
		String cOpenStatusString = "";
		System.out.println("CMD" + cmd);
		int bId = 1;
		String bId_ = request.getParameter("bId");
		if (bId_ != null && !bId_.equals(""))
			bId = Integer.parseInt(bId_);

		if (edel != null && !edel.equals("")) {
			switch (edel) {
			case "수정":
				response.sendRedirect("/trade/edit");
				break;
			case "삭제":
				int id = tradeService.getBoardId();
				int boardId = id;
				int result = tradeService.deleteTrade(id);
				System.out.println("result: " + result);
				int result2 = tradeItemService.deleteByTradeBoardId(boardId);
				System.out.println("result2: " + result2);
				int result3 = tradeImgService.deleteByTradeBoardId(boardId);
				System.out.println("result3: " + result3);
				int result4 = tradeCommentService.deleteTradeComment(boardId);
				System.out.println("result4: " + result4);
				response.sendRedirect("/trade/list");
				break;
			}
		}
		if (cmd != null && !cmd.equals("")) {
			switch (cmd) {
			case "등록":
				cId_ = request.getParameter("cId");
				if (cId_ != null && !cId_.equals(""))
					cId = Integer.parseInt(cId_);
				String cContent_ = request.getParameter("cContent");
				if (cContent_ != null && !cContent_.contentEquals(""))
					cContent = cContent_;
				String cUserName = "";
				if (request.getSession().getAttribute("userName") != null) {
					cUserName = (String) request.getSession().getAttribute("userName");
				}
				Member member = memberService.get(cUserName);
				cUserId = member.getId();
				// String cUserName = memberService.get(cUserId).getUserName();

				// if(cUserId_1!=null && !cUserId_1.equals(""))
				// String cUserId_ = request.getParameter("cUserId");
				// if(cUserId_!=null && !cUserId_.equals(""))
				// cUserId = Integer.parseInt(cUserId_);
				String cBId_ = request.getParameter("bId");
				if (cBId_ != null && !cBId_.equals(""))
					cBId = Integer.parseInt(cBId_);
				String cOpenStatus_ = request.getParameter("cOpenStatus");
				if (cOpenStatus_ != null && !cOpenStatus_.equals(""))
					cOpenStatusString = cOpenStatus_;
				if (cOpenStatusString.equals("on")) {
					cOpenStatus = 1;
				} else {
					cOpenStatus = 0;
				}
				int result = tradeCommentService
						.insertTradeComment(new TradeComment(cContent, cUserId, cBId, cOpenStatus));

				System.out.println("cId:" + cId + "cBId:" + cBId + "cContent:" + cContent + "cUserId:" + cUserId
						+ "openStatus" + cOpenStatus);
				System.out.println("result" + result);

				response.sendRedirect("/trade/detail?id=" + bId);
				break;
			case "수정":
				cId_ = request.getParameter("cId");
				if (cId_ != null && !cId_.equals(""))
					cId = Integer.parseInt(cId_);
				String cContent_1 = request.getParameter("cContent");
				if (cContent_1 != null && !cContent_1.contentEquals(""))
					cContent = cContent_1;
				String cUserId_ = request.getParameter("cUserId");
				if (cUserId_ != null && !cUserId_.equals(""))
					cUserId = Integer.parseInt(cUserId_);
				String cBId_1 = request.getParameter("bId");
				if (cBId_1 != null && !cBId_1.equals(""))
					cBId = Integer.parseInt(cBId_1);
				String cOpenStatus_1 = request.getParameter("cOpenStatus");
				if (cOpenStatus_1 != null && !cOpenStatus_1.equals(""))
					cOpenStatusString = cOpenStatus_1;
				if (cOpenStatusString.equals("on")) {
					cOpenStatus = 1;
				} else {
					cOpenStatus = 0;
				}
				int edit = tradeCommentService.updateTradeComment(new TradeComment(cId, cContent, cUserId, cBId));
				System.out.println(tradeCommentService.toString());
				response.sendRedirect("/trade/detail?id=" + cBId);
				// response.sendRedirect("/trade/detail?id="+cBId);
				break;
			case "삭제":
				cId_ = request.getParameter("cId");
				if (cId_ != null && !cId_.equals(""))
					cId = Integer.parseInt(cId_);
				System.out.println(cId_);
				System.out.println(cId);
				int del = tradeCommentService.deleteTradeComment(cId);
				System.out.println("cId:" + cId + "삭제됐니" + del);
				response.sendRedirect("/trade/detail?id=" + bId);
				break;
			}
		}

	}
}

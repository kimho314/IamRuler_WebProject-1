package com.imruler.web.controller.coordi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.CoordiBoard;
import com.imruler.web.entity.CoordiComment;
import com.imruler.web.entity.Member;
import com.imruler.web.service.CoordiBoardService;
import com.imruler.web.service.CoordiCommentService;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.coordi.RulerCoordiBoardService;
import com.imruler.web.service.coordi.RulerCoordiCommentService;
import com.imruler.web.service.member.RulerMemberService;

@WebServlet("/coordi/comment")
public class CoordiCommentController extends HttpServlet
{
	private CoordiCommentService coordiCommentService;
	private MemberService memberService;
	private CoordiBoardService coordiBoardService;
	
	public CoordiCommentController()
	{
		coordiCommentService = new RulerCoordiCommentService();
		memberService = new RulerMemberService();
		coordiBoardService = new RulerCoordiBoardService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO doGet
		int cb_id = 0;
		String _cbId = req.getParameter("cb_id");
		if(_cbId != null && !_cbId.equals(""))
		{
			cb_id = Integer.parseInt(_cbId);
		}
		
		int ccmtId = 0;
		String _ccmtId = req.getParameter("id");
		if(_ccmtId != null && !_ccmtId.equals(""))
		{
			ccmtId = Integer.parseInt(_ccmtId);
		}
		
				
		int opt = 0;
		String _opt = req.getParameter("opt");
		if(_opt != null && !_opt.equals(""))
		{
			opt = Integer.parseInt(_opt);
		}
		
		
		switch(opt)
		{
		case 1: // updating a comment
			req.setAttribute("cmt", coordiCommentService.get(ccmtId));
			break;
			
		case 2:	// deleting a comment
			coordiCommentService.delete(ccmtId);
			break;
			
		default:
			break;
		}
				
		int cb_userId = coordiBoardService.getCoordiBoard(cb_id).getUserId();
		int loggedInUserId = 0;
		if(req.getSession().getAttribute("userName") != null && !req.getSession().getAttribute("userName").equals(""))
		{
			loggedInUserId = memberService.get((String)req.getSession().getAttribute("userName")).getId();
		}
		int isWriter = 0;
		if(cb_userId == loggedInUserId)
		{
			isWriter = 1;
		}
		
		req.setAttribute("isWriter", isWriter);
		req.setAttribute("opt", opt);
		req.setAttribute("cmtList", coordiCommentService.getList(cb_id));
		req.getRequestDispatcher("/WEB-INF/view/coordi/comment.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO doPost
		int ccmt_openStat = 0;
		String _ccmt_openStat = req.getParameter("demo-copy");
		if(_ccmt_openStat != null && !_ccmt_openStat.equals(""))
		{
			if(_ccmt_openStat.equals("on"))
			{
				ccmt_openStat = 1;
			}
		}
		
		int ccmt_bId = 0;
		String _ccmt_bId = req.getParameter("boardId-text");
		if(_ccmt_bId != null && !_ccmt_bId.equals(""))
		{
			ccmt_bId = Integer.parseInt(_ccmt_bId);
		}
		
		
		String m_userName = "";
		if(req.getSession().getAttribute("userName") != null && !req.getSession().getAttribute("userName").equals(""))
		{
			m_userName = (String) req.getSession().getAttribute("userName");
		}
		System.out.println("userName : " + m_userName);
		
		String ccmt_content = "";
		String _ccmt_content = req.getParameter("demo-message");
		if(_ccmt_content != null && !_ccmt_content.equals(""))
		{
			ccmt_content = _ccmt_content;
		}
		
		int commentOptText = 0;
		String _commentOptText = req.getParameter("opt-text");
		if(_commentOptText != null && !_commentOptText.equals(""))
		{
			commentOptText = Integer.parseInt(_commentOptText);
		}
		
		int cmtId = 0;
		String _cmtId = req.getParameter("cmtId-text");
		if(_cmtId != null && !_cmtId.equals(""))
		{
			cmtId = Integer.parseInt(_cmtId);
		}		
		
		//System.out.println(commentOptText + " " + ccmt_content + " " + m_userName + " " + ccmt_bId + " " + ccmt_openStat);
		
		
		if(commentOptText == 1) // update comment
		{
			CoordiComment coordiCommet = coordiCommentService.get(cmtId);
			coordiCommet.setContent(ccmt_content);
			coordiCommet.setOpenStat(ccmt_openStat);
			coordiCommentService.update(coordiCommet);
		}
		else // add a new comment
		{
			Member member = memberService.get(m_userName);
			CoordiComment coordiCommet = new CoordiComment(ccmt_content, member.getId(), ccmt_bId, ccmt_openStat);
			coordiCommentService.insert(coordiCommet);
		}
		
		
		String url = "comment?cb_id=" + String.valueOf(ccmt_bId);
		resp.sendRedirect(url);
	}
}

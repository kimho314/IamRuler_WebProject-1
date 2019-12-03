package com.imruler.web.controller.coordi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.CoordiComment;
import com.imruler.web.service.CoordiCommentService;
import com.imruler.web.service.coordi.RulerCoordiCommentService;

@WebServlet("/coordi/comment")
public class CoordiCommentController extends HttpServlet
{
	private CoordiCommentService coordiCommentService;
	
	public CoordiCommentController()
	{
		coordiCommentService = new RulerCoordiCommentService();
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
		case 1:
			req.setAttribute("cmt", coordiCommentService.get(ccmtId));
			break;
			
		case 2:			
			coordiCommentService.delete(ccmtId);
			break;
			
		default:
			break;
		}
		
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
		
		int ccmt_userId = 0;
		String _ccmt_userId = req.getParameter("userId-text");
		if(_ccmt_userId != null && !_ccmt_userId.equals(""))
		{
			ccmt_userId = Integer.parseInt(_ccmt_userId);
		}
		
		String ccmt_content = "";
		String _ccmt_content = req.getParameter("demo-message");
		if(_ccmt_content != null && !_ccmt_content.equals(""))
		{
			ccmt_content = _ccmt_content;
		}
		
		int optText = 0;
		String _optText = req.getParameter("opt-text");
		if(_optText != null && !_optText.equals(""))
		{
			optText = Integer.parseInt(_optText);
		}
		
		int cmtId = 0;
		String _cmtId = req.getParameter("cmtId-text");
		if(_cmtId != null && !_cmtId.equals(""))
		{
			cmtId = Integer.parseInt(_cmtId);
		}
		
		
		System.out.println(optText + " " + ccmt_content + " " + ccmt_userId + " " + ccmt_bId + " " + ccmt_openStat);
		
		
		if(optText == 1) // update comment
		{
			CoordiComment coordiCommet = coordiCommentService.get(cmtId);
			coordiCommet.setContent(ccmt_content);
			coordiCommet.setOpenStat(ccmt_openStat);
			coordiCommentService.update(coordiCommet);
		}
		else // add a new comment
		{
			CoordiComment coordiCommet = new CoordiComment(ccmt_content, ccmt_userId, ccmt_bId, ccmt_openStat);
			coordiCommentService.insert(coordiCommet);
		}
		
		
		String url = "comment?cb_id=" + String.valueOf(ccmt_bId);
		resp.sendRedirect(url);
	}
}

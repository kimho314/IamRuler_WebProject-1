package com.imruler.web.controller.coordi;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.CoordiBoard;
import com.imruler.web.entity.CoordiBoardView;
import com.imruler.web.entity.CoordiPostDetailView;
import com.imruler.web.service.CoordiBoardService;
import com.imruler.web.service.CoordiCommentService;
import com.imruler.web.service.CoordiImgService;
import com.imruler.web.service.CoordiOptionService;
import com.imruler.web.service.CoordiPostService;
import com.imruler.web.service.coordi.RulerCoordiBoardService;
import com.imruler.web.service.coordi.RulerCoordiCommentService;
import com.imruler.web.service.coordi.RulerCoordiImgService;
import com.imruler.web.service.coordi.RulerCoordiOptionService;
import com.imruler.web.service.coordi.RulerCoordiPostService;

@WebServlet("/coordi/post")
public class CoordiPostController extends HttpServlet
{
	private CoordiPostService coordiPostDetailService;
	private CoordiBoardService coordiBoardService;
	private CoordiCommentService coordiBoardCommentService;
	private CoordiImgService coordiImgService;
	private CoordiOptionService coordiOptionService;
	
	public CoordiPostController()
	{
		coordiPostDetailService = new RulerCoordiPostService();
		coordiBoardService = new RulerCoordiBoardService();
		coordiBoardCommentService = new RulerCoordiCommentService();
		coordiImgService = new RulerCoordiImgService();
		coordiOptionService = new RulerCoordiOptionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		int cb_id = 0;
		String _cb_id = req.getParameter("cb_id");
	
		if(_cb_id != null && !_cb_id.equals(""))
		{
			cb_id = Integer.parseInt(_cb_id);
		}
		
		int opt = 0;
		String _opt = req.getParameter("opt");
		if(_opt != null && !_opt.equals(""))
		{
			opt = Integer.parseInt(_opt);
		}
				
		switch (opt)
		{
		case 1: // post detail revise sequence
			resp.sendRedirect("reg_post?cb_id=" + cb_id);
			break;

		case 2: // post detail delete sequence		
			coordiBoardService.delete(cb_id);
			coordiBoardCommentService.deleteByCoodiBoardId(cb_id);
			coordiImgService.deleteByCoordiBoardId(cb_id);
			coordiOptionService.delete(cb_id);

		default:
			CoordiPostDetailView postDetail = coordiPostDetailService.getCoordiPostDetailById(cb_id);

			String tmpStr = postDetail.getCi_img().replace("\\", "/");
			if(tmpStr != null && !tmpStr.equals(""))
			{
				String retStr = "";
				if (tmpStr.indexOf(",") != -1)
				{
					retStr = tmpStr.substring(0, tmpStr.indexOf(","));
				}
				else
				{
					retStr = tmpStr;
				}
				
				postDetail.setCi_img(retStr);
			}
			

			req.setAttribute("pdetail", postDetail);
			req.getRequestDispatcher("/WEB-INF/view/coordi/post.jsp").forward(req, resp);
			break;
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
	}
}

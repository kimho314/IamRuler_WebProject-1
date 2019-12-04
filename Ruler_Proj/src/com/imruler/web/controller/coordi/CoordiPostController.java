package com.imruler.web.controller.coordi;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.CoordiBoard;
import com.imruler.web.entity.CoordiBoardView;
import com.imruler.web.entity.CoordiPostDetailView;
import com.imruler.web.service.CoordiBoardService;
import com.imruler.web.service.CoordiCommentService;
import com.imruler.web.service.CoordiContentService;
import com.imruler.web.service.CoordiImgService;
import com.imruler.web.service.CoordiOptionService;
import com.imruler.web.service.CoordiPostService;
import com.imruler.web.service.coordi.RulerCoordiBoardService;
import com.imruler.web.service.coordi.RulerCoordiCommentService;
import com.imruler.web.service.coordi.RulerCoordiContentService;
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
	private CoordiContentService coordiContentService;
	
	public CoordiPostController()
	{
		coordiPostDetailService = new RulerCoordiPostService();
		coordiBoardService = new RulerCoordiBoardService();
		coordiBoardCommentService = new RulerCoordiCommentService();
		coordiImgService = new RulerCoordiImgService();
		coordiOptionService = new RulerCoordiOptionService();
		coordiContentService = new RulerCoordiContentService();
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
		
		String gender = "";
		String _gender = req.getParameter("g");
		if(_gender != null && !_gender.equals(""))
		{
			gender = _gender;
		}		
		
		String genderEncoded = URLEncoder.encode(gender, "UTF-8");	
		
		switch (opt)
		{
		case 1: // post detail revise sequence
			int updateOpt = 1;
			req.getSession().setAttribute("updateOpt", updateOpt);
//			Cookie updateCookie = new Cookie("updateOpt", String.valueOf(updateOpt));
//			updateCookie.setPath("/");
//			resp.addCookie(updateCookie);
			resp.sendRedirect("reg_post?cb_id="+cb_id+"&g="+genderEncoded);
			break;

		case 2: // post detail delete sequence		
			coordiBoardService.delete(cb_id);
			coordiContentService.delete(cb_id);
			coordiBoardCommentService.deleteByCoodiBoardId(cb_id);
			coordiImgService.deleteByCoordiBoardId(cb_id);
			coordiOptionService.delete(cb_id);

		default:
			CoordiPostDetailView postDetail = coordiPostDetailService.getCoordiPostDetailById(cb_id);

			String tmpStr = postDetail.getCi_img().replace("\\", "/");
			String[] cImgs = new String[] {""};
			if(tmpStr != null && !tmpStr.equals(""))
			{				
				if (tmpStr.indexOf(",") != -1)
				{
					cImgs = tmpStr.split(",");
				}
				else
				{
					cImgs[0] = tmpStr;
				}
				/*	
				for(String cImg : cImgs)
				{
					System.out.println(cImg);
				}
				*/
			}
						
			
			req.setAttribute("cImgs", cImgs);
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

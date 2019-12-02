package com.imruler.web.controller.coordi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.imruler.web.entity.CoordiBoard;
import com.imruler.web.entity.CoordiComment;
import com.imruler.web.entity.CoordiContent;
import com.imruler.web.entity.CoordiImg;
import com.imruler.web.entity.CoordiOption;
import com.imruler.web.entity.CoordiPostDetailView;
import com.imruler.web.entity.Member;
import com.imruler.web.service.CoordiBoardService;
import com.imruler.web.service.CoordiCommentService;
import com.imruler.web.service.CoordiContentService;
import com.imruler.web.service.CoordiImgService;
import com.imruler.web.service.CoordiOptionService;
import com.imruler.web.service.CoordiPostService;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.coordi.RulerCoordiBoardService;
import com.imruler.web.service.coordi.RulerCoordiCommentService;
import com.imruler.web.service.coordi.RulerCoordiContentService;
import com.imruler.web.service.coordi.RulerCoordiImgService;
import com.imruler.web.service.coordi.RulerCoordiOptionService;
import com.imruler.web.service.coordi.RulerCoordiPostService;
import com.imruler.web.service.member.RulerMemberService;

@WebServlet("/coordi/reg_post")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, 
maxFileSize = 1024 * 1024 * 100, 
maxRequestSize = 1024 * 1024 * 100 * 5)
public class CoordiRegPostController extends HttpServlet
{
	private CoordiPostService coordiPostDetailService;
	private CoordiBoardService coordiBoardService;
	private CoordiContentService coordiContentService;
	private CoordiImgService coordiImgService;
	private CoordiOptionService coordiOptionService;
	private MemberService memberService;
	
	public CoordiRegPostController()
	{
		coordiPostDetailService = new RulerCoordiPostService();
		coordiBoardService = new RulerCoordiBoardService();
		coordiContentService = new RulerCoordiContentService();
		coordiImgService = new RulerCoordiImgService();
		coordiOptionService = new RulerCoordiOptionService();
		memberService = new RulerMemberService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO doGet
		int cb_id = 0;
		String _cb_id = req.getParameter("cb_id");
		if(_cb_id != null && !_cb_id.equals(""))
		{
			cb_id = Integer.parseInt(_cb_id);
		}
		
		String gender = "";
		String _gender = req.getParameter("g");
		if(_gender != null && !_gender.equals(""))
		{
			gender = _gender;
		}
				
		CoordiPostDetailView coordiPostDetailView = coordiPostDetailService.getCoordiPostDetailById(cb_id);
		if(coordiPostDetailView != null)
		{			
			req.setAttribute("pDetail", coordiPostDetailView);
		}
		
		req.setAttribute("g", gender);
		req.getRequestDispatcher("/WEB-INF/view/coordi/reg_post.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		// TODO doPost
		
		// get neccesary datas from reg_post.jsp
		String cct_title = "";
		String _cct_title = req.getParameter("coordi-post-table-title");
		if(_cct_title != null && !_cct_title.equals(""))
		{
			cct_title = _cct_title;
		}
		
		
//		Date cb_regdate = null;
//		String _cb_regdate = req.getParameter("coordi-post-table-regdate");
//		if(_cb_regdate != null && !_cb_regdate.equals(""))
//		{
//			try
//			{
//				cb_regdate = new SimpleDateFormat("YYYY-MM-DD").parse(_cb_regdate);
//			}
//			catch (ParseException e)
//			{
//				e.printStackTrace();
//			}
//		}
		
		String co_bodyshape = "";
		String _co_bodyshape = req.getParameter("bodyshape-category");
		if(_co_bodyshape != null && !_co_bodyshape.equals(""))
		{
			co_bodyshape = _co_bodyshape;
		}
		
		String cct_content = "";
		String _cct_content = req.getParameter("content-message");
		if(_cct_content != null && !_cct_content.equals(""))
		{
			cct_content = _cct_content;
		}
		
		String gender = "여성";
		String _gender = req.getParameter("gender-field");
		if(_gender != null && !_gender.equals(""))
		{
			gender = _gender;
		}
				
		
		Collection<Part> parts = req.getParts();
		String fileNames = "";
		String urlPath = File.separator + "ruler_storage";
		
		for(Part p : parts)
		{
			if(!p.getName().equals("files[]"))
				continue;
			
			Part filePart = p;
			String fileName = filePart.getSubmittedFileName();
			fileNames += (urlPath + File.separator + fileName + ",");
			
			
			ServletContext application = req.getServletContext();
			
			String realPath = application.getRealPath(urlPath);
			//String realPath = new File("." + fileNames).getCanonicalPath();
		
			//System.out.println("tmpPath : " + req.getSession().getServletContext().getRealPath("/"));
			
			File file = new File(realPath);
			if (!file.exists())
			{
				file.mkdirs();
			}
			else
			{
				System.out.println("경로존재함");
			}
			
			System.out.println("realPath : " + realPath);

			InputStream fis = filePart.getInputStream();
			FileOutputStream fos = new FileOutputStream(realPath + File.separator + fileName);
			
			byte[] buf = new byte[1024];

			int size = 0;
			while ((size = fis.read(buf)) != -1)
			{
				fos.write(buf, 0, size);
			}
			fos.close();
		}
		
		fileNames = fileNames.substring(0, fileNames.length()-1);
		//System.out.println(fileNames);
		
		// implements inserting
		int m_id = 1; 
		
		String userName = (String)req.getSession().getAttribute("userName");
		m_id = memberService.get(userName).getId();
		
		int result = 0;
		coordiBoardService.insert(new CoordiBoard(m_id));
		int cb_maxId = coordiBoardService.getMaxId();		
		coordiContentService.insert(new CoordiContent(cb_maxId, cct_title, cct_content, ""));		
		coordiImgService.insert(new CoordiImg(cb_maxId, fileNames));
		coordiOptionService.insert(new CoordiOption(cb_maxId, co_bodyshape, gender));
		
		
		if(gender.equals("남성"))
		{
			resp.sendRedirect("list_m");
		}
		else
		{
			resp.sendRedirect("list_w");
		}
	}
}

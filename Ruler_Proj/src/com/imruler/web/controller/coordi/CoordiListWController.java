package com.imruler.web.controller.coordi;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imruler.web.entity.CoordiBoard;
import com.imruler.web.entity.CoordiBoardView;
import com.imruler.web.service.CoordiBoardService;
import com.imruler.web.service.coordi.RulerCoordiBoardService;

@WebServlet("/coordi/list_w")
public class CoordiListWController extends HttpServlet
{
	private CoordiBoardService coordiBoardService;
	
	public CoordiListWController()
	{
		coordiBoardService = new RulerCoordiBoardService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{	
		int page = 1;
		String gender = "여성";
		String bodyshape = "";
		
		String _page = req.getParameter("p");
		if(_page != null && !_page.equals(""))
		{
			page = Integer.parseInt(_page);
		}
		
		String _gender = req.getParameter("g");
		if(_gender != null && !_gender.equals(""))
		{
			gender = _gender;
		}
		
		String _bodyshape = req.getParameter("b");
		if(_bodyshape != null && !_bodyshape.equals(""))
		{
			bodyshape = _bodyshape; 
		}
		
				
		List<CoordiBoardView> coordiBoardViewList =  coordiBoardService.getList(page, gender, bodyshape);
		for(CoordiBoardView key : coordiBoardViewList)
		{
			String tmpStr = key.getCi_img().replace("\\", "/");
			String retStr = "";
			if(tmpStr.indexOf(",") != -1)
			{
				retStr = tmpStr.substring(0,tmpStr.indexOf(","));
			}
			else
			{
				retStr = tmpStr;
			}
			//System.out.println(retStr);
			key.setCi_img(retStr);
		}
				
	
		req.setAttribute("list", coordiBoardViewList);
		req.setAttribute("listCount", coordiBoardService.getListCount(gender, bodyshape));
		req.getRequestDispatcher("/WEB-INF/view/coordi/list_w.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		
	}
}

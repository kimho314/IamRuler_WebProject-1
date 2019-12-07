package com.imruler.web.controller.trade.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeImg;
import com.imruler.web.entity.TradeItem;
import com.imruler.web.entity.TradeView;
import com.imruler.web.service.TradeImgService;
import com.imruler.web.service.TradeItemService;
import com.imruler.web.service.TradeService;
import com.imruler.web.service.TradeViewService;
import com.imruler.web.service.ruler.RulerTradeImgService;
import com.imruler.web.service.ruler.RulerTradeItemService;
import com.imruler.web.service.ruler.RulerTradeService;

@WebServlet("/trade/edit")
@MultipartConfig(/**/
		fileSizeThreshold = 1024 * 1024, /**/
		maxFileSize = 1024 * 1024 * 10, /**/
		maxRequestSize = 1024 * 1024 * 10 * 5/**/
)
public class TradeEditController extends HttpServlet
{
	private TradeService tradeService;
	private TradeImgService tradeImgService;
	private TradeItemService tradeItemService;
	private TradeViewService tradeViewService;

	private int id;

	public TradeEditController()
	{
		id = 0;
		tradeService = new RulerTradeService();
		tradeImgService = new RulerTradeImgService();
		tradeItemService = new RulerTradeItemService();
		tradeViewService = new RulerTradeService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		id = Integer.parseInt(request.getParameter("bId"));
		//int id = Integer.parseInt(request.getParameter("id"));
		TradeView tradeView = tradeViewService.getTrade(id);
		request.setAttribute("t", tradeView);
		request.getRequestDispatcher("/WEB-INF/view/trade/edit.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int userId = 1;
		int boardId = 1;
		String title = "";
		String content = "";
		String category = "";
		String region = "";
		String bodyShape = "";
		String complete = "";

		String title_ = request.getParameter("title");
		if (title_ != null && !title_.equals(""))
			title = title_;

		String content_ = request.getParameter("content");
		if (content_ != null && !content_.equals(""))
			content = content_;

		String category_ = request.getParameter("category");
		if (category_ != null && !category_.equals(""))
			category = category_;

		String region_ = request.getParameter("region");
		if (region_ != null && !region_.equals(""))
			region = region_;

		String bodyShape_ = request.getParameter("bodyShape");
		if (bodyShape_ != null && !bodyShape_.equals(""))
			bodyShape = bodyShape_;

		String complete_ = request.getParameter("complete");
		if (complete_ != null && !complete_.equals(""))
			complete = complete_;
		if (complete.contentEquals("on"))
		{
			complete = "거래완료";
		}

		String userId_ = request.getParameter("userId");
		if (userId_ != null && !userId_.equals(""))
			userId = Integer.parseInt(userId_);

		//boardId = tradeService.getBoardId();
		boardId = id;
		/*
		 * System.out.println("edit boardId:" + boardId);
		 * System.out.println(category+region+bodyShape);
		 */
		Collection<Part> parts = request.getParts();

		String fileNames = "";
		String urlPath = File.separator + "ruler_storage";

		for (Part p : parts)
		{
			if (!p.getName().equals("files"))
				continue;

			Part filePart = p;
			String fileName = filePart.getSubmittedFileName(); // 전송한 파일명
			fileNames += (urlPath + File.separator + fileName + ",");

			ServletContext application = request.getServletContext();
			String realPath = application.getRealPath(urlPath);

			File file = new File(realPath);
			if (!file.exists())
				file.mkdir();
			else
				System.out.println("경로존재");

			InputStream fis = filePart.getInputStream(); // 전송한 파일의 스트림
			try (FileOutputStream fos = new FileOutputStream(realPath + File.separator + fileName))
			{
				byte[] buf = new byte[1024];
				int size = 0;
				while ((size = fis.read(buf)) != -1)
					fos.write(buf, 0, size);
				fos.close();
			}
			catch (Exception e)
			{
				break;
			}
		}

		fileNames = fileNames.substring(0, fileNames.length() - 1);

		String userName = (String) request.getSession().getAttribute("userName");

		int result = tradeService.updateTrade(new TradeBoard(boardId, title, content, complete));	
		int result2 = tradeItemService.update(new TradeItem(boardId, bodyShape, category, region));		
		int result3 = tradeImgService.update(new TradeImg(boardId, fileNames));
		
		response.sendRedirect("/trade/list");
	}

}

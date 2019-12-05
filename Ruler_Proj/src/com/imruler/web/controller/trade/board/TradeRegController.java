package com.imruler.web.controller.trade.board;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.imruler.web.entity.Member;
import com.imruler.web.entity.TradeBoard;
import com.imruler.web.entity.TradeImg;
import com.imruler.web.entity.TradeItem;
import com.imruler.web.service.MemberService;
import com.imruler.web.service.TradeImgService;
import com.imruler.web.service.TradeItemService;
import com.imruler.web.service.TradeService;
import com.imruler.web.service.member.RulerMemberService;
import com.imruler.web.service.ruler.RulerTradeImgService;
import com.imruler.web.service.ruler.RulerTradeItemService;
import com.imruler.web.service.ruler.RulerTradeService;

@WebServlet("/trade/reg")
@MultipartConfig(/**/
		fileSizeThreshold = 1024 * 1024, /**/
		maxFileSize = 1024 * 1024 * 10, /**/
		maxRequestSize = 1024 * 1024 * 10 * 5/**/
)
public class TradeRegController extends HttpServlet {

	private TradeService tradeService;
	private TradeImgService tradeImgService;
	private TradeItemService tradeItemService;
	private MemberService memberService;

	public TradeRegController() {
		tradeService = new RulerTradeService();
		tradeImgService = new RulerTradeImgService();
		tradeItemService = new RulerTradeItemService();
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
			}
		}
		if (cookie != null) {
			for (Cookie key : cookie) {
				Cookie c = key;
				cValue = c.getValue();
			}
		}
		HttpSession session = request.getSession();
	
		String userId = cValue;
		if (userId == null) {
			userId = (String) session.getAttribute("userName");
		}
		request.getRequestDispatcher("/WEB-INF/view/trade/reg.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = 0;
		String userName ="";
		if(request.getSession().getAttribute("userName") != null)
		{
			userName = (String) request.getSession().getAttribute("userName");
		}
		Member member = memberService.get(userName);
		userId = member.getId();
		
		int boardId = 0;
		String title = "";
		String content = "";
		String category = "";
		String region = "";
		String bodyShape = "";
		String complete = "";
		String tag = "";

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
//		String userId_ = request.getParameter("userId");
//		if (userId_ != null && !userId_.equals(""))
//			userId = Integer.parseInt(userId_);
		String tag_ = request.getParameter("tag");
		if (tag_ != null && !tag_.equals(""))
			tag = tag_;
		
		Collection<Part> parts = request.getParts();

		String fileNames = "";
		
		for (Part p : parts) {
			if (!p.getName().equals("files"))
				continue;

			Part filePart = p;
			String fileName = filePart.getSubmittedFileName(); // 전송한 파일명

			fileNames += fileName + ",";

			ServletContext application = request.getServletContext();
			String urlPath = "/upload";
			String realPath = application.getRealPath(urlPath);

			File file = new File(realPath);
			if (!file.exists())
				file.mkdir();
			else
				System.out.println("경로존재");

			InputStream fis = filePart.getInputStream(); // 전송한 파일의 스트림
			OutputStream fos = new FileOutputStream(realPath + File.separator + fileName);

			byte[] buf = new byte[1024];
			int size = 0;
			while ((size = fis.read(buf)) != -1)
				fos.write(buf, 0, size);
			fos.close();
		}
		fileNames = fileNames.substring(0, fileNames.length()-1);
		
		//String userName = (String) request.getSession().getAttribute("userName");
		
		int result = tradeService.insertTrade(new TradeBoard(title, content, tag, userId));
		System.out.println("result: " + result);
		boardId = tradeService.getBoardId();
		int result2 = tradeItemService.insert(new TradeItem(boardId, bodyShape, category, region));
		System.out.println("result2: " + result2);
		int result3 = tradeImgService.insert(new TradeImg(boardId, fileNames));
		System.out.println("result3: " + result3);
		
		response.sendRedirect("list");

	}

}

package com.imruler.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sign/agree")
public class AgreeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO doGet
		req.getRequestDispatcher("/WEB-INF/view/sign/agree.jsp").forward(req, resp);
	}
}

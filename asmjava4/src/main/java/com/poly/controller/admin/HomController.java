package com.poly.controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/admin", name = "HomeControllerOfAdmin")
public class HomController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2479314105269346804L;
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	req.getRequestDispatcher("/views/admin/Home.jsp").forward(req, resp);
	
}
}

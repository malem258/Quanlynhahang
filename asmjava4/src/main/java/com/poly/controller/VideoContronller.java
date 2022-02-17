package com.poly.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.hibernate.SessionBuilder;

import com.poly.constant.SessionAttr;
import com.poly.entity.History;
import com.poly.entity.User;
import com.poly.entity.Video;
import com.poly.service.HistoryService;
import com.poly.service.VideoService;
import com.poly.service.impl.HistoryServiceImpl;
import com.poly.service.impl.VideoServiceImpl;


@WebServlet(urlPatterns = "/video")
public class VideoContronller extends HttpServlet {	

	
	private static final long serialVersionUID = -9091413715567997370L;
	private HistoryService historyService = new HistoryServiceImpl(); 
	
	private VideoService videoService = new VideoServiceImpl();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String actionParam = req.getParameter("action");
	HttpSession session = req.getSession();
	switch (actionParam) {
	case "watch":
		String id = req.getParameter("id");
		dogetWatch(session,id,req,resp);
		break;
	case "like":
		String href = req.getParameter("id");
		dogetLike(session,href, req, resp);
		break;
	}	
}
private void dogetWatch(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	Video video = videoService.findByHref(href);
	req.setAttribute("video", video);
	User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
	if(currentUser != null) {
		History history = historyService.create(currentUser,video);
		req.setAttribute("flagLikedBtn", history.getIsLiked());
	}
	
	req.getRequestDispatcher("/views/user/video-detail.jsp").forward(req, resp);
	
}
private void dogetLike(HttpSession session, String href, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		User currentUser = (User) session.getAttribute(SessionAttr.CURRENT_USER);
		boolean result = historyService.updateLikeOrUnlike(currentUser, href);
		if(result == true) {
			resp.setStatus(204);
			
		}else {
			resp.setStatus(400);
			
		}
		
}
}

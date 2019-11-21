package com.skillstorm.servlet_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet{

	private TimeSheetController timesheetController = new TimeSheetController();

	protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		
		switch (req.getMethod()) 
		{
		case "GET": timesheetController.getCredentials(req, resp);
					return;
		case "POST":// timesheetController.postArtist(req, resp);
					return;
		case "PUT": //timesheetController.putArtist(req, resp);
					return;
		default:
			break;
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
		String firstName = "null";// = req.getParameter("userid");
		String lastName = "null";// = req.getParameter("password");
		
		System.out.println(req.getMethod());
		System.out.println(req.getRequestURI());
		System.out.println("Hello, " + firstName + " " + lastName);
		resp.getWriter().print("Hello, " + firstName + " " + lastName);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//doDispatch(req, resp);
		String firstName = req.getParameter("userid");
		String lastName = req.getParameter("password"); 
		 
		
		//resp.getWriter().print("Hello, " + firstName + " " + lastName);
	}
}
 
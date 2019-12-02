package com.skillstorm.servlet_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.skillstorm.data.User;

public class DispatcherServlet extends HttpServlet{
	
	private TimeSheetController timesheetController = new TimeSheetController();

	protected void doDispatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("~~~~~~~~~~~~~~~ DispatcherServlet: doDispatch ~~~~~~~~~~~~~~~~~~~\n");
		
		String uri = req.getRequestURI();
		String requestType = req.getMethod();
		
		if(requestType.equals("GET"))
		{
			switch (uri) 
			{
			case "/timesheet/portal/timesheet-new":
				System.out.println("~~~~~~~~~~~~~~~ DispatcherServlet: /timesheet/portal/timeSheet-new ~~~~~~~~~~~~~~~~~~~\n");
				timesheetController.NewTimeSheet(req, resp);
				return;
			case "/timesheet/portal/timesheet-get":
				System.out.println("~~~~~~~~~~~~~~~ DispatcherServlet: /timesheet/portal/timeSheet-get ~~~~~~~~~~~~~~~~~~~\n");
				timesheetController.getTimeSheet(req, resp);
				return;
			case "/timesheet/portal/timesheet-getall":
				System.out.println("~~~~~~~~~~~~~~~ DispatcherServlet: /timesheet/portal/timeSheet-getall ~~~~~~~~~~~~~~~~~~~\n");
				timesheetController.getAllTimesheetabyUserId(req, resp);
				return;
			default:
				System.out.println(uri + " is not correct address");
				break;
			}
		
		}
		else if(requestType.equals("POST"))
		{
			switch (uri) 
			{
			case "/timesheet/portal/timesheet-save":	
				System.out.println("~~~~~~~~~~~~~~~ DispatcherServlet: /timesheet/portal/timesheet-save ~~~~~~~~~~~~~~~~~~~\n");
				timesheetController.SaveTimeSheet(req, resp);
				return;						
			case "/timesheet/portal/timesheet-submit":
				timesheetController.SubmitTimeSheet(req, resp);
				System.out.println("~~~~~~~~~~~~~~~ DispatcherServlet: /timesheet/portal/timesheet-submit ~~~~~~~~~~~~~~~~~~~\n");
				return;
			case "/timesheet/portal/login":	
				System.out.println("~~~~~~~~~~~~~~~ DispatcherServlet: /timesheet/portal/login ~~~~~~~~~~~~~~~~~~~\n");
				timesheetController.getCredentials(req, resp);
				return;
			default:
				System.out.println(uri + " is not correct address");
				break;
			}
		}
		else
		{
			System.out.println(requestType + " is not used as a request type");
		}
		
		System.out.println("~~~~~~~~~~~~~~~ DispatcherServlet: doDispatch End ~~~~~~~~~~~~~~~~~~~\n");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("~~~~~~~~~~~~~~~ doGet ~~~~~~~~~~~~~~~~~~~\n");
		
		doDispatch(req, resp);
		
		System.out.println(req.getParameter("userid"));
		System.out.println(req.getParameter("dateEnd"));
		System.out.println(req.getSession().getAttribute("userinfo"));
		
		System.out.println(req.getRequestURI());
		System.out.println("~~~~~~~~~~~~~~~ doGet End ~~~~~~~~~~~~~~~~~~~\n");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("~~~~~~~~~~~~~~~ doPost ~~~~~~~~~~~~~~~~~~~\n");
		
		doDispatch(req, resp);
		
		System.out.println(req.getParameter("password"));
		System.out.println(req.getParameter("username"));
		System.out.println(req.getSession().getAttribute("userinfo"));
		
		System.out.println(req.getRequestURI());
		System.out.println("~~~~~~~~~~~~~~~ doPost End~~~~~~~~~~~~~~~~~~~\n");
	}
}
 
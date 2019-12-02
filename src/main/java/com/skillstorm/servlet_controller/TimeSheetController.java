package com.skillstorm.servlet_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.data.TimeSheet;
import com.skillstorm.data.User;
import com.skillstorm.service.TimeSheetService;

public class TimeSheetController 
{
	TimeSheetService timesheetservice = new TimeSheetService();
	
	public void getCredentials(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: getCredentials ~~~~~~~~~~~~~~~~~~~\n");
		
		resp.setContentType("application/json");
				
		// Get the Username/Password entered
		User userIn =  new User();//new ObjectMapper().readValue(req.getInputStream(), User.class);//
		User userOut = new User();
		userIn.setUsername(req.getParameter("username"));
		userIn.setPassword(req.getParameter("password"));
		
		userOut = timesheetservice.getCredentialsbyUsername(userIn);
		
		resp.getWriter().println(new ObjectMapper().writeValueAsString(userOut));
		
		if (userOut.isLoggedIn())
		{
			userOut.setPassword("");
			req.getSession().setAttribute("userinfo", userOut);
		}
		else
		{
			resp.setStatus(401);
		}
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: getCredentials End ~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public void NewTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: NewTimeSheet ~~~~~~~~~~~~~~~~~~~\n");
		
		int userid = Integer.parseInt(req.getParameter("userid"));
		String dateEnd = req.getParameter("dateEnd");
		
		timesheetservice.NewTimeSheet(userid, dateEnd);
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: NewTimeSheet End ~~~~~~~~~~~~~~~~~~~\n");		
		}
	
	public void SubmitTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: SubmitTimeSheet ~~~~~~~~~~~~~~~~~~~\n");
		
		int userid = Integer.parseInt(req.getParameter("userid"));
		String dateEnd = req.getParameter("dateEnd");
		
		timesheetservice.SubmitTimeSheet(userid, dateEnd);
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: SubmitTimeSheet End ~~~~~~~~~~~~~~~~~~~\n");		
		}
	
	public void SaveTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: SaveTimeSheet ~~~~~~~~~~~~~~~~~~~\n");
				
		resp.setContentType("application/json");
		timesheetservice.SaveTimeSheet(new ObjectMapper().readValue(req.getInputStream(), TimeSheet.class));
		
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: SaveTimeSheet End ~~~~~~~~~~~~~~~~~~~\n");		
		}
	
	public void getTimeSheet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: getTimeSheet ~~~~~~~~~~~~~~~~~~~\n");
		
		TimeSheet timesheet = new TimeSheet();
		int userid = Integer.parseInt(req.getParameter("userid"));
		String dateEnd = req.getParameter("dateEnd");
		
		timesheet = timesheetservice.getTimeSheet(userid, dateEnd);
		
		resp.getWriter().println(new ObjectMapper().writeValueAsString(timesheet));
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: getTimeSheet End ~~~~~~~~~~~~~~~~~~~\n");		
	}
	
	public void getAllTimesheetabyUserId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: getAllTimesheetabyUserId ~~~~~~~~~~~~~~~~~~~\n");
		
		int userid = Integer.parseInt(req.getParameter("userid"));
		resp.getWriter().println(new ObjectMapper().writeValueAsString(timesheetservice.getAllTimesheetabyUserId(userid)));
	System.out.println("~~~~~~~~~~~~~~~ TimeSheetController: getAllTimesheetabyUserId End ~~~~~~~~~~~~~~~~~~~\n");		
	}
}

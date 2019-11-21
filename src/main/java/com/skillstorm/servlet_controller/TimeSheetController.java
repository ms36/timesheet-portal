package com.skillstorm.servlet_controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillstorm.service.TimeSheetService;

public class TimeSheetController 
{
	public void getCredentials(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		TimeSheetService timesheetservice = new TimeSheetService();
		String param = req.getParameter("username");

		resp.setContentType("application/json");
		
		if(param != null)
		{
			
			
			resp.getWriter().println(new ObjectMapper()
					.writeValueAsString(timesheetservice.getCredentialsbyUsername(param)));	
		}
		else
		{			
			resp.getWriter().append("This is a require field"); //TODO change this to display over the login
			resp.sendRedirect("/timesheet/");
		}
	}
}

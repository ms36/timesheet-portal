package com.skillstorm.service;

import com.skillstorm.DAO.TimeSheetDAO;
import com.skillstorm.data.User;

public class TimeSheetService 
{
	TimeSheetDAO timesheetdao = new TimeSheetDAO();
	
	public User getCredentialsbyUsername(String username) {
		
	return timesheetdao.getCredentialsbyUsername(username);
	
	}
}

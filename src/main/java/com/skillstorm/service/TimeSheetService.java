package com.skillstorm.service;

import java.util.LinkedList;
import java.util.List;

import com.skillstorm.DAO.TimeSheetDAO;
import com.skillstorm.data.TimeSheet;
import com.skillstorm.data.User;

public class TimeSheetService 
{
	TimeSheetDAO timesheetdao = new TimeSheetDAO();
	
	public User getCredentialsbyUsername(User userFromClient) 
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: getCredentialsbyUsername ~~~~~~~~~~~~~~~~~~~\n");
		User userFromDataBase = null;
		
		// Path to Database from Client
		if(userFromClient.getUsername() != null)
		{			
			userFromDataBase = timesheetdao.getCredentialsbyUsername(userFromClient.getUsername());			
		}
		else
		{
			//TODO return message saying nothing is entered
			System.out.println("TimeSheetService: User name is null");
		}
		
		// Path back to Client
		// If username/password match
		if(((userFromClient.getPassword()).equals(userFromDataBase.getPassword()))
		&& ((userFromClient.getUsername()).equals(userFromDataBase.getUsername())))
		{
			userFromDataBase.setLoggedIn(true);
			System.out.println("TimeSheetService: Success! You are logged in");
		}
		else
		{
			System.out.println("TimeSheetService: User name and password don't match");
			System.out.println("TimeSheetService: UserInput username: " + userFromClient.getUsername());
			System.out.println("TimeSheetService: Retrieved username: " + userFromDataBase.getUsername());
			System.out.println("TimeSheetService: UserInput password: " + userFromClient.getPassword());
			System.out.println("TimeSheetService: Retrieved password: " + userFromDataBase.getPassword());
			
		}
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: getCredentialsbyUsername End ~~~~~~~~~~~~~~~~~~~\n");
		return userFromDataBase;
	}
	
	
	public void NewTimeSheet(int userid, String dateEnd)
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: NewTimeSheet ~~~~~~~~~~~~~~~~~~~\n");
		timesheetdao.NewTimeSheet(userid, dateEnd);
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: NewTimeSheet End ~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public void SubmitTimeSheet(int userid, String dateEnd)
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: SubmitTimeSheet ~~~~~~~~~~~~~~~~~~~\n");
		timesheetdao.SubmitTimeSheet(userid, dateEnd);
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: SubmitTimeSheet End ~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public void SaveTimeSheet(TimeSheet timesheet)
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: SaveTimeSheet ~~~~~~~~~~~~~~~~~~~\n");
		timesheetdao.SaveTimeSheet(timesheet);
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: SaveTimeSheet End ~~~~~~~~~~~~~~~~~~~\n");
	}
	
	public TimeSheet getTimeSheet(int userid, String dateEnd)
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: getTimeSheet ~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: getTimeSheet End ~~~~~~~~~~~~~~~~~~~\n");
		return timesheetdao.getTimeSheet(userid, dateEnd);
	}
	
	public List<TimeSheet> getAllTimesheetabyUserId(int userid)
	{
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: getAllTimesheetabyUserId ~~~~~~~~~~~~~~~~~~~\n");
		
		System.out.println("~~~~~~~~~~~~~~~ TimeSheetService: getAllTimesheetabyUserId End ~~~~~~~~~~~~~~~~~~~\n");
		return timesheetdao.getAllTimesheetabyUserId(userid);
	}
}

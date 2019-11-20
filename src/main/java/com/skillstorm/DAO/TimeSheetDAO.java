package com.skillstorm.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.skillstorm.data.User;
import com.skillstorm.servlet_controller.ConnectionFactory;

public class TimeSheetDAO 
{
	Connection connection = null;
	PreparedStatement preStatement = null;
	ResultSet resultSet = null;

	private Connection getConnection() throws SQLException 
	{
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public User findByUserName(String username) throws SQLException 
	{
		String query = "SELECT UserId, UserName FROM user WHERE userid = ?";
		connection = getConnection();
		
		preStatement = connection.prepareStatement(query);
		preStatement.setString(1, username);
		
		resultSet = preStatement.executeQuery();
		resultSet.next(); 
		
		User user = new User(resultSet.getString(2), resultSet.getString(3));
		connection.close();
		
		return user;
	}
	
	public User getCredentials(String username) throws SQLException 
	{
		String query = "SELECT UserName, PassWord FROM user WHERE username = ?";
		connection = getConnection();
		
		preStatement = connection.prepareStatement(query);
		preStatement.setString(1, username);
		
		resultSet = preStatement.executeQuery();
		resultSet.next(); 
		
		User user = new User(resultSet.getString(1), resultSet.getString(2));
		connection.close();
		
		return user;
	}
	
	/// ************************ TEST ***************************************
	public static void main(String[] args) throws SQLException 
	{
		TimeSheetDAO dao = new TimeSheetDAO();
		User user = dao.getCredentials("ms36");
		
		System.out.print(user.getUserame() + " ");
		System.out.println(user.getPassword());
		/*Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/macgyver", "root", "Root");
		
		Statement stmt = conn.createStatement();		
		String sql = "select * from user";
		
		ResultSet rs = stmt.executeQuery(sql);
		LinkedList<User> results = new LinkedList<User>();
		while(rs.next()) 
		{
			User a = new User(rs.getString("UserName"), rs.getString("Password"));
			results.add(a);
			
			System.out.print(rs.getString("UserName") + " ");
			System.out.println(rs.getString("Password"));
		}*/
	}
	// TODO Add more methods in TimeSheetDAO
/*public List<TimeSheet> findTimeSheetByUser(int id){};
public TimeSheet findTimeSheetbyId(int id) {};
public TimeSheet save(TimeSheet t) {};*/
}

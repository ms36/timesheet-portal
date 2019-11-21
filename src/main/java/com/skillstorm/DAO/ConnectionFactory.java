package com.skillstorm.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	String driverClassName = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/macgyver";
	String user = "root";
	String password = "Root";
	
	private static ConnectionFactory connectFactory;
	
	private ConnectionFactory()
	{
		try {
			Class.forName(driverClassName);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found");
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException
	{
		Connection conn = null;	
		conn = DriverManager.getConnection(url, user, password);
		
		return conn;
	}
	
	public static ConnectionFactory getInstance() {
		if (connectFactory == null) 
		{
			connectFactory = new ConnectionFactory();
		} 
		return connectFactory;
	}
}

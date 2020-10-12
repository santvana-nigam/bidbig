package com.hsbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	private Connection connection = null;
	
	public DBConnection() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bidbig","root","root");
			System.out.println("hello");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public PreparedStatement getPreparedStatement(String s) {
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(s);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pst;
	}
	
	public Statement getStatement() {
		Statement st = null;
		try {
			st = connection.createStatement();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return st;
	}
}

package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	
	private static Connection conn;
	public static Connection getconn() {
		try {
			Class.forName("com.mysql.cj.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ebook-app","root","biswa463");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
}
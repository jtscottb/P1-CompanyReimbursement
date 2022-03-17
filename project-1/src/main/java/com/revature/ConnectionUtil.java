package com.revature;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	private static Connection conn;
	private static String url = "jdbc:postgresql://localhost:5432/Databases/postgres/p1";
	private static String usr = "postgres";
	private static String pswd = "Livestrong18!";
	
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, usr, pswd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}

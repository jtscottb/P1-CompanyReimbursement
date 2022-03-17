package com.revature;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/Login")
public class EmployeeDao extends HttpServlet {
	private static final long serialVersionUID = -1558339471607760734L;
	
	private static Connection conn;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public static void test() {
		List<Integer> list = new ArrayList<Integer>();
		
		conn = ConnectionUtil.getConnection();
		String query = "select user_role_id from user_roles";
		
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(rs.getInt("user_role_id"));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		System.out.println(list);
	}
}

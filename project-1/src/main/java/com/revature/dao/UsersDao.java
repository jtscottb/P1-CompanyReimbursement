package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.User;
import com.revature.util.ConnectionUtil;

public class UsersDao {
	private static Connection con;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public UsersDao() {
		con = ConnectionUtil.getConnection();
	}
	
	public int addUser(User u) {
		String query = "insert into users (username, password, firstname, lastname, email, role_id) values (?, ?, ?, ?, ?, ?)";
		int added = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getFirstName());
			pstmt.setString(4, u.getLastName());
			pstmt.setString(5, u.getEmail());
			pstmt.setInt(6, u.getRoleId());
			added = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return added;
	}
	
	public int updateUser(User u) {
		String query = "update users "
						+ "set username=?, password=?, firstname=?, lastname=?, email=?, role_id=? "
						+ "where userid=?";
		int update = 0;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, u.getUsername());
			pstmt.setString(2, u.getPassword());
			pstmt.setString(3, u.getFirstName());
			pstmt.setString(4, u.getLastName());
			pstmt.setString(5, u.getEmail());
			pstmt.setInt(6, u.getRoleId());
			pstmt.setInt(7, u.getId());
			update = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}
	
	public User getUser(int id) {
		User u = new User();
		String query = "select * from users "
						+ "inner join roles on users.role_id = roles.roleid "
						+ "where userid=" + id;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				u.setId(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setEmail(rs.getString("email"));
				u.setRoleId(rs.getInt("role_id"));
				u.setRole(rs.getString("role"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public User getUser(String uname, String pword) {
		User u = new User();
		String query = "select * from users "
						+ "inner join roles on users.role_id = roles.roleid "
						+ "where username=?";
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, uname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				u.setId(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setEmail(rs.getString("email"));
				u.setRoleId(rs.getInt("role_id"));
				u.setRole(rs.getString("role"));
			}
			if(!u.getPassword().equals(pword)) {
				u = null;
			}
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}
	
	public List<User> getAllEmployees() {
		List<User> employees = new ArrayList<User>();
		String query = "select * from users "
						+ "inner join roles on users.role_id = roles.roleid";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				User u = new User();
				u.setId(rs.getInt("userid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFirstName(rs.getString("firstname"));
				u.setLastName(rs.getString("lastname"));
				u.setEmail(rs.getString("email"));
				u.setRoleId(rs.getInt("role_id"));
				u.setRole(rs.getString("role"));
				employees.add(u);
			}
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employees;
	}
	
	public void setCurrentUser(User u) {
		String query = "update users set active=1 where userid=" + u.getId().intValue();
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public User getCurrentUser() {
		User user = new User();
		String query = "select * from users "
						+ "inner join roles on users.role_id=roles.roleid "
						+ "where active is true";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				user.setId(rs.getInt("userid"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setEmail(rs.getString("email"));
				user.setRoleId(rs.getInt("role_id"));
				user.setRole(rs.getString("role"));
			}
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public void removeCurrentUser() {
		String query = "update users set active=0 where active is true";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(query);
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

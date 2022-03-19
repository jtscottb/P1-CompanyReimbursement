package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.revature.Reimbursement;
import com.revature.util.ConnectionUtil;

public class ReimbursementDao {
	private static Connection con;
	private static Statement stmt;
	private static PreparedStatement pstmt;
	private static ResultSet rs;
	
	public ReimbursementDao() {
		con = ConnectionUtil.getConnection();
	}
	
	public Reimbursement addReimbursement(Reimbursement r) {
		String query = "insert into reimbusement (amount, submitted, resolved, description, author, status_id, type_id) "
						+ "values (?, ?, ?, ?, ?, ?, ?)";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, r.getAmount());
			pstmt.setObject(2, r.getSubmitted());
			pstmt.setObject(3, r.getResolved());
			pstmt.setInt(4, r.getAuthorId());
			pstmt.setInt(5, r.getStatusId());
			pstmt.setInt(6, r.getTypeId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;
	}
	
	public void updateReimbursement(Reimbursement r) {
		String query = "update reimbursement "
						+ "set resolved=?, resolver=?, status_id=?, type_id=? "
						+ "where id=?";
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setObject(1, r.getResolved());
			pstmt.setInt(2, r.getResolverId());
			pstmt.setInt(3, r.getStatusId());
			pstmt.setInt(4, r.getTypeId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		UsersDao ud = new UsersDao();
		String query = "select * from reimbursement "
						+ "inner join status on reimbursement.status_id=status.id "
						+ "inner join type on reimbursement.type_id=type.id";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setAmount(rs.getDouble("amount"));
				r.setSubmitted((LocalDateTime) rs.getTimestamp("submitted").toLocalDateTime());
				r.setResolved((LocalDateTime) rs.getTimestamp("resolved").toLocalDateTime());
				r.setDescription(rs.getString("description"));
				r.setAuthorId(rs.getInt("author"));
				r.setResolverId(rs.getInt("resolver"));
				r.setType(rs.getString("type"));
				r.setStatus(rs.getString("status"));
				
				String author = ud.getUser(r.getAuthorId()).getFname() + " " + ud.getUser(r.getAuthorId()).getLname();
				String resolver = ud.getUser(r.getResolverId()).getFname() + " " + ud.getUser(r.getResolverId()).getLname();
				r.setAuthorName(author);
				r.setResolverName(resolver);
				
				reimbursements.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public Reimbursement getReimbursement(int id) {
		Reimbursement r = new Reimbursement();
		List<Reimbursement> reimbursements = getAllReimbursements();
		for(Reimbursement re : reimbursements) {
			if(re.getId().equals(id)) {
				r = re;
				break;
			}
		}
		return r;
	}
	
	public List<Reimbursement> getReimbursementsByUser(int id) {
		List<Reimbursement> reimbursements = getAllReimbursements();
		for(Reimbursement r : reimbursements) {
			if(!r.getAuthorId().equals(id)) {
				reimbursements.remove(r);
			}
		}
		return reimbursements;
	}
	
	public List<Reimbursement> getReimbursementByType(String type) {
		List<Reimbursement> reimbursements = getAllReimbursements();
		for(Reimbursement r : reimbursements) {
			if(!r.getType().equals(type)) {
				reimbursements.remove(r);
			}
		}
		return reimbursements;
	}
	
}

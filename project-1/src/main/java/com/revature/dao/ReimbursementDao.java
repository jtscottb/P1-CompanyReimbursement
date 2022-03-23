package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
	
	public int addReimbursement(Reimbursement r) {
		String query = "insert into reimbursement (amount, submitted, resolved, description, author, status_id, type_id) "
						+ "values (?, ?, ?, ?, ?, ?, ?)";
		int added = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setDouble(1, r.getAmount());
			pstmt.setObject(2, r.getSubmitted());
			pstmt.setObject(3, r.getResolved());
			pstmt.setString(4, r.getDescription());
			pstmt.setInt(5, r.getAuthorId());
			pstmt.setInt(6, r.getStatusId());
			pstmt.setInt(7, r.getTypeId());
			added = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return added;
	}
	
	public int updateReimbursement(Reimbursement r) {
		String query = "update reimbursement "
						+ "set resolved=?, resolver=?, status_id=?, type_id=? "
						+ "where id=?";
		int update = 0;
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setObject(1, r.getResolved());
			pstmt.setInt(2, r.getResolverId());
			pstmt.setInt(3, r.getStatusId());
			pstmt.setInt(4, r.getTypeId());
			pstmt.setInt(5, r.getId());
			update = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return update;
	}
	
	public List<Reimbursement> getAllReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		UsersDao ud = new UsersDao();
		String query = "select * from reimbursement "
						+ "inner join status on reimbursement.status_id=status.statusid "
						+ "inner join type on reimbursement.type_id=type.typeid";
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) {
				Reimbursement r = new Reimbursement();
				r.setId(rs.getInt("id"));
				r.setAmount(rs.getDouble("amount"));
				r.setSubmitted(rs.getTimestamp("submitted").toLocalDateTime());
				Timestamp resolved = rs.getTimestamp("resolved");
				r.setResolved(Objects.isNull(resolved) ? null : resolved.toLocalDateTime());
				r.setDescription(rs.getString("description"));
				r.setAuthorId(rs.getInt("author"));
				r.setResolverId(rs.getInt("resolver"));
				r.setTypeId(rs.getInt("type_id"));
				r.setType(rs.getString("type"));
				r.setStatusId(rs.getInt("status_id"));
				r.setStatus(rs.getString("status"));
				
				String author = ud.getUser(r.getAuthorId()).getFirstName() + " " + ud.getUser(r.getAuthorId()).getLastName();
				r.setAuthorName(author);
				String resolver = ud.getUser(r.getResolverId()).getFirstName() + " " + ud.getUser(r.getResolverId()).getLastName();
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
		List<Reimbursement> myReimbursements = new ArrayList<>();
		for(Reimbursement r : reimbursements) {
			if(r.getAuthorId().equals(id)) {
				myReimbursements.add(r);
			}
		}
		return myReimbursements;
	}
	
	public List<Reimbursement> getReimbursementsByStatus(int status) {
		List<Reimbursement> reimbursements = getAllReimbursements();
		List<Reimbursement> myReimbursements = new ArrayList<>();
		for(Reimbursement r : reimbursements) {
			if(r.getStatusId().equals(status)) {
				myReimbursements.add(r);
			}
		}
		return myReimbursements;
	}
	
}

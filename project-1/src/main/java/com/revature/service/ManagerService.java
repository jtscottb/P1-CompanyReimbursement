package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.Reimbursement;
import com.revature.Table;
import com.revature.User;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UsersDao;

public class ManagerService {
	/*
	A Manager can logout
    A Manager can approve/deny pending reimbursement requests
    A Manager can view all pending requests from all employees
    A Manager can view images of the receipts from reimbursement requests (extra credit)
    A Manager can view all resolved requests from all employees and see which manager resolved it
    A Manager can view all Employees
    A Manager can view reimbursement requests from a single Employee
	*/
	public boolean approveOrDeny(Reimbursement r) {
		ReimbursementDao rd = new ReimbursementDao();
		boolean updated = false;
		updated = rd.updateReimbursement(r) == 0 ? false : true;
		return updated;
	}
	
	public String viewAllRequestsByType(String type) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		Table t = new Table();
		ReimbursementDao rd = new ReimbursementDao();
		reimbursements = rd.getReimbursementsByType(type.toUpperCase());
		String table = t.generateHTMLTable(reimbursements);
		return table;
	}
	
	public String viewAllEmployees() {
		List<User> users = new ArrayList<User>();
		Table t = new Table();
		UsersDao ud = new UsersDao();
		users = ud.getAllEmployees();
		String table = t.generateHTMLTable(users);
		return table;
	}
	
	public String viewEmployeeRequests(User u) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		Table t = new Table();
		ReimbursementDao rd = new ReimbursementDao();
		reimbursements = rd.getReimbursementsByUser(u.getId());
		String table = t.generateHTMLTable(reimbursements);
		return table;
	}
	
}

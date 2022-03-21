package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.Reimbursement;
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
	
	public List<Reimbursement> viewAllRequestsByStatus(int status) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		ReimbursementDao rd = new ReimbursementDao();
		try {
			reimbursements = rd.getReimbursementsByStatus(status);
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("No reimbursements by that type");
			e.printStackTrace();
		}
		return reimbursements;
	}
	
	public List<User> viewAllEmployees() {
		List<User> users = new ArrayList<User>();
		UsersDao ud = new UsersDao();
		users = ud.getAllEmployees();
		return users;
	}
	
	public List<Reimbursement> viewEmployeeRequests(User u) {
		List<Reimbursement> reimbursements = new ArrayList<Reimbursement>();
		ReimbursementDao rd = new ReimbursementDao();
		try {
			reimbursements = rd.getReimbursementsByUser(u.getId());
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("No reimbursements by that type");
			e.printStackTrace();
		}
		return reimbursements;
	}
	
}

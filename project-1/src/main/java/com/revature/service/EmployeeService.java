package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import com.revature.Reimbursement;
import com.revature.User;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UsersDao;

public class EmployeeService {
	/*
	An Employee can logout
    An Employee can submit a reimbursement request
    An Employee can upload an image of his/her receipt as part of the reimbursement request (extra credit)
    An Employee can view their pending reimbursement requests
    An Employee can view their resolved reimbursement requests
    An Employee can view their information
    An Employee can update their information
    An Employee receives an email when one of their reimbursement requests is resolved (optional)
	*/
	public boolean submitRequest(Reimbursement r) {
		ReimbursementDao rd = new ReimbursementDao();
		boolean submitted = false;
		r.setStatusId(3);
		r.setSubmitted();
		submitted = rd.addReimbursement(r) == 0 ? false : true;
		return submitted;
	}
	
	public List<Reimbursement> viewPendingRequests(User u) {
		List<Reimbursement> myReimbursements = new ArrayList<Reimbursement>();
		ReimbursementDao rd = new ReimbursementDao();
		List<Reimbursement> reimbursements = rd.getReimbursementsByUser(u.getId());
		try {
			for(Reimbursement r : reimbursements) {
				if(r.getStatusId().equals(3)) {
					myReimbursements.add(r);
				}
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("No reimbursement requests made");
			e.printStackTrace();
		}
		return myReimbursements;
	}
	
	public List<Reimbursement> viewResolvedRequests(User u) {
		List<Reimbursement> myReimbursements = new ArrayList<Reimbursement>();
		ReimbursementDao rd = new ReimbursementDao();
		List<Reimbursement> reimbursements = rd.getReimbursementsByUser(u.getId());
		try {
			for(Reimbursement r : reimbursements) {
				if(!r.getStatus().equals("PENDING")) {
					myReimbursements.add(r);
				}
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			System.out.println("No reimbursement requests made");
			e.printStackTrace();
		}
		return myReimbursements;
	}
	
	public User viewInfo(int id) {
		UsersDao ud = new UsersDao();
		User u = ud.getUser(id);
		return u;
	}
	
	public boolean updateInfo(User u) {
		UsersDao ud = new UsersDao();
		boolean updated = false;
		updated = ud.updateUser(u) == 0 ? false : true;
		return updated;
	}
	
}

package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerService ms = new ManagerService();
		EmployeeService es = new EmployeeService();
		List<User> list = new ArrayList<User>();
		List<Reimbursement> list2 = new ArrayList<Reimbursement>();
		User u = new User();
		Reimbursement r = new Reimbursement();
		Table t = new Table();
		
		u.setEmail("e");
		u.setFname("f");
		u.setId(24);
		u.setLname("l");
		u.setPassword("p");
		u.setRole("r");
		u.setRoleId(2);
		u.setUsername("u");
		
		r.setAmount(1d);
		r.setAuthorId(24);
		r.setAuthorName("a");
		r.setDescription("d");
		r.setId(3);
		r.setResolved();
		r.setResolverId(25);
		r.setResolverName("r");
		r.setStatus("s");
		r.setStatusId(3);
		r.setSubmitted();
		r.setType("t");
		r.setTypeId(1);
		
		list.add(u);
		list2.add(r);
		
//		System.out.println(ms.generateHTMLTable(list2));
		System.out.println(t.generateHTMLTable(list2));
		System.out.println(es.submitRequest(r));
		System.out.println(es.viewInfo(u.getId()));
		System.out.println(es.viewPendingRequests(u));
		System.out.println(es.viewResolvedRequests(u));
	}
}

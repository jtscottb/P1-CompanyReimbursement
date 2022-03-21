package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.service.EmployeeService;
import com.revature.service.ManagerService;
import com.revature.service.Startup;

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
		String table = null;
		
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
		r.setId(4);
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
		
//		System.out.println(es.submitRequest(r));
		
//		System.out.println(es.viewInfo(u.getId()));
//		table = t.generateHTMLTable(es.viewInfo(u.getId()));
//		System.out.println(table);
		
//		System.out.println(es.viewPendingRequests(u));
//		list2 = es.viewPendingRequests(u);
//		if(!list2.isEmpty()) {
//			table = t.generateHTMLTable(list2);
//		}
//		System.out.println(table);
		
//		System.out.println(es.viewResolvedRequests(u));
//		list2 = es.viewResolvedRequests(u);
//		if(!list2.isEmpty()) {
//			table = t.generateHTMLTable(list2);
//		}
//		System.out.println(table);
		
//		r.setStatusId(2);
//		System.out.println(ms.approveOrDeny(r));
//		r.setStatusId(1);
//		System.out.println(ms.approveOrDeny(r));
		
//		list2 = ms.viewAllRequestsByStatus(3);
//		if(!list2.isEmpty()) {
//			table = t.generateHTMLTable(list2);
//		}
//		System.out.println(table);
		
//		list = ms.viewAllEmployees();
//		if(!list.isEmpty()) {
//			table = t.generateHTMLTable(list);
//		}
//		System.out.println(table);
		
//		u.setId(25);
//		list2 = ms.viewEmployeeRequests(u);
//		if(!list2.isEmpty()) {
//			table = t.generateHTMLTable(list2);
//		}
//		System.out.println(table);
		
		String username = "JTSCOTTB";
		String password = "passwords";
		Startup s = new Startup();
		try {
			System.out.println(s.login(username, password));
		} catch (InvalidCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(s.register(u));
		} catch (UsernameAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

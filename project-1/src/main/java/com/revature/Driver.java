package com.revature;

import java.util.ArrayList;
import java.util.List;

import com.revature.service.ManagerService;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ManagerService ms = new ManagerService();
		User u = new User();
		u.setEmail("e");
		u.setFname("f");
		u.setId(1);
		u.setLname("l");
		u.setPassword("p");
		u.setRole("r");
		u.setRoleId(2);
		u.setUsername("u");
		Reimbursement r = new Reimbursement();
		r.setAmount(1d);
		r.setAuthorId(2);
		r.setAuthorName("a");
		r.setDescription("d");
		r.setId(3);
		r.setResolved();
		r.setResolverId(4);
		r.setResolverName("r");
		r.setStatus("s");
		r.setStatusId(5);
		r.setSubmitted();
		r.setType("t");
		r.setTypeId(6);
		List<User> list = new ArrayList<User>();
		List<Reimbursement> list2 = new ArrayList<Reimbursement>();
		list.add(u);
		list2.add(r);
		Table t = new Table();
//		System.out.println(ms.generateHTMLTable(list2));
		System.out.println(t.generateHTMLTable(list2));
	}
}

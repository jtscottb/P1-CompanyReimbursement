package com.revature.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.revature.User;
import com.revature.dao.UsersDao;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.util.SessionCache;

public class Startup {

	public User login(String uname, String pword) throws InvalidCredentialsException {
		User u = new User();
		UsersDao ud = new UsersDao();
		u = ud.getUser(uname, pword);
		
		if(Objects.isNull(u)) {
			throw new InvalidCredentialsException("Invalid username or password");
		} else {
			SessionCache.setCurrentUser(u);
		}
		return u;
	}
	
	public User register(User u) throws UsernameAlreadyExistsException {
		UsersDao ud = new UsersDao();
		List<User> users = ud.getAllEmployees();
		List<String> unames = new ArrayList<String>();
		
		users.forEach(user -> unames.add(user.getUsername()));
		if(unames.contains(u.getUsername())) {
			throw new UsernameAlreadyExistsException("Username already taken");
		} else {
			ud.addUser(u);
		}
		return u;
	}
}

package com.revature.util;

import java.util.Optional;

import com.revature.User;

public class SessionCache {
	
	private static Optional<User> loggedInUser;
	
	public static Optional<User> getCurrentUser() {
		return loggedInUser;
	}
	
	public static void setCurrentUser(User u) {
		loggedInUser = Optional.ofNullable(u);
	}

}


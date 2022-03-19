package com.revature.exceptions;

public class UsernameAlreadyExistsException extends Exception{

	private static final long serialVersionUID = -5955805821400140623L;

		public UsernameAlreadyExistsException(String message) {
			super(message);
		}
}

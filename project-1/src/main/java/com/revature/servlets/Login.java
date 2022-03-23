package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.User;
import com.revature.exceptions.InvalidCredentialsException;
import com.revature.service.Startup;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = "<label for=uname>Username</label> <br>"
						+ "<input type=text id=uname name=uname> <br> <br>";
		String password = "<label for=pword>Password</label> <br>"
			    		+ "<input type=password id=pword name=pword> <br> <br>";
		String submit = "<input type=submit value=Login>";
		String form = "<form action=./Login method=post>" + username + password + submit + "</form>";
		
		String content = form;
		request.setAttribute("content", content);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		User u = new User();
		Startup s = new Startup();
		
		String uname = request.getParameter("uname").toUpperCase();
		String pword = request.getParameter("pword");
		
		try {
			u = s.login(uname, pword);
			String role = u.getRole();
			String message = "WELCOME " + u.getFirstName() + " " + u.getLastName();
			request.setAttribute("role", role.toUpperCase());
			request.setAttribute("message", message);
			request.setAttribute("js", role.toLowerCase() + ".js");
			getServletContext().getRequestDispatcher("/" + role.toLowerCase() + ".jsp").forward(request, response);
		} catch (InvalidCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String message = e.getMessage();
			request.setAttribute("load", "Login()");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
	
}

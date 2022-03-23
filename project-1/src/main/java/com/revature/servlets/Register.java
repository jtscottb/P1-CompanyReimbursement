package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.User;
import com.revature.exceptions.UsernameAlreadyExistsException;
import com.revature.service.Startup;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		User u = new User();
		Startup s = new Startup();
		
		u.setUsername(request.getParameter("uname").toUpperCase());
		u.setPassword(request.getParameter("pword"));
		u.setFirstName(request.getParameter("fname").toUpperCase());
		u.setLastName(request.getParameter("lname").toUpperCase());
		u.setEmail(request.getParameter("email"));
		u.setRoleId(Integer.parseInt(request.getParameter("role")));
		
		
		try {
			s.register(u);
			request.setAttribute("load", "Login()");
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (UsernameAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			String message = e.getMessage();
			request.setAttribute("load", "Register()");
			request.setAttribute("message", message);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}

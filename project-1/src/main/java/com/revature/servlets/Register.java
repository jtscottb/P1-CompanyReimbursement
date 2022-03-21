package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		User u = new User();
		Startup s = new Startup();
		
		u.setUsername(request.getParameter("uname").toUpperCase());
		u.setPassword(request.getParameter("pword"));
		u.setFname(request.getParameter("fname").toUpperCase());
		u.setLname(request.getParameter("lname").toUpperCase());
		u.setEmail(request.getParameter("email"));
		u.setRoleId(Integer.parseInt(request.getParameter("role")));
		
		
		try {
			s.register(u);
			pw.write("<html>"
					+ "<head>\r\n"
					+ "		<meta charset=\"UTF-8\">\r\n"
					+ "		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
					+ "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "		<link rel=\"stylesheet\" href=\"./CSS/main.css\">\r\n"
					+ "		<script src=\"./JS/main.js\"></script>"
					+ "</head>"
					+ "<body onload=\"Login()\">"
					+ "		<div id=block>"
					+ "			<div id=choice></div>"
					+ "		</div>"
					+ "</body>"
					+ "</html>");
		} catch (UsernameAlreadyExistsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.write("<h4> Error is " + e.getMessage() + "</h4>");
		}
	}

}

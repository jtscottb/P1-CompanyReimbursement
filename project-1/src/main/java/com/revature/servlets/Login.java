package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

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
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		User u = new User();
		Startup s = new Startup();
		
		String uname = request.getParameter("uname").toUpperCase();
		String pword = request.getParameter("pword");
		
		try {
			u = s.login(uname, pword);
			String role = u.getRole();
			pw.write("<html>"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>"+ role.toUpperCase() +" HOME</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"./CSS/main.css\">\r\n"
				+ "		<script src=\"./JS/" + role.toLowerCase() + ".js\"></script>"
				+ "</head>"
				+ "<body>"
				+ "		<h3 id=\"welcome\">WELCOME " + u.getFname() + " " + u.getLname() + "</h3>"
				+ "</body>"
				+ "</html>");
		} catch (InvalidCredentialsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			pw.write("<h1>Login Error " + e.getMessage() + "</h1>");
		}
	}
	
}

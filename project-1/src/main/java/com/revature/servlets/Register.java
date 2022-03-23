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
	    String role = "<input type=radio id=role1 name=role value=1 checked>"
				    + "<label for=role1>EMPLOYEE</label> &nbsp; &nbsp;"
				    + "<input type=radio id=role2 name=role value=2>"
				    + "<label for=role2>MANAGER</label> <br> <br>";

	    String uname = "<label for=uname>Username</label> <br>"
	    			+ "<input type=text id=uname name=uname placeholder=user> <br> <br>";

	    String pword = "<label for=pword>Password</label> <br>"
	    			+ "<input type=password id=pword name=pword placeholder=password> <br> <br>";

	    String fname = "<label for=fname>First Name</label> <br>"
	    			+ "<input type=text id=fname name=fname placeholder='first name'> <br> <br>";

	    String lname = "<label for=lname>Last Name</label> <br>"
	    			+ "<input type=text id=lname name=lname placeholder='last name'> <br> <br>";

	    String email = "<label for=email>Email</label> <br>"
	    			+ "<input type=email id=email name=email placeholder=user@email.com> <br> <br>";
	    
	    String submit = "<input type=submit value=Register>";
	    
	    String form = "<form action=./Register method=post>" + role + uname + pword + fname + lname + email + submit + "</form>";
	    
	    String content = form;
		request.setAttribute("content", content);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
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

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
		String div = "<div class=\"form-group row mb-3\">";
		String col = "<div class=\"col-sm-1 w-25\">";
		String endDiv = "</div>";
		
	    String role = "<div class=\"form-check form-check-inline mb-3\">"
	    			+ "<input class=form-check-input type=radio id=role1 name=role value=1 checked>"
				    + "<label class=form-check-label for=role1>EMPLOYEE</label> &nbsp; &nbsp;"
	    			+ endDiv
	    			+ "<div class=\"form-check form-check-inline\">"
				    + "<input class=form-check-input type=radio id=role2 name=role value=2>"
				    + "<label class=form-check-label for=role2>MANAGER</label>"
				    + endDiv;

	    String uname = div
	    			+ "<label for=uname class=\"col-sm-1 col-form-label\">Username:</label>"
	    			+ col
	    			+ "<input class=\"form-control\" type=text id=uname name=uname placeholder=username required>"
	    			+ endDiv + endDiv;

	    String pword = div
	    			+ "<label for=pword class=\"col-sm-1 col-form-label\">Password:</label>"
	    			+ col
	    			+ "<input class=\"form-control\" type=password id=pword name=pword placeholder=password required>"
	    			+ endDiv + endDiv;

	    String fname = div
	    			+ "<label for=fname class=\"col-sm-1 col-form-label\">First Name:</label>"
	    			+ col
	    			+ "<input class=\"form-control\" type=text id=fname name=fname placeholder='first name' required>"
	    			+ endDiv + endDiv;

	    String lname = div
	    			+ "<label for=lname class=\"col-sm-1 col-form-label\">Last Name:</label>"
	    			+ col
	    			+ "<input class=\"form-control\" type=text id=lname name=lname placeholder='last name' required>"
	    			+ endDiv + endDiv;

	    String email = div
	    			+ "<label for=email class=\"col-sm-1 col-form-label\">Email:</label>"
	    			+ col
	    			+ "<input class=\"form-control\" type=email id=email name=email placeholder=user@email.com required>"
	    			+ endDiv + endDiv;
	    
	    String submit = "<button type=\"submit\" class=\"btn btn-secondary\"> Register </button>";
	    
	    String form = "<form action=./Register method=post>"
	    			+ role + uname + pword + fname + lname + email + submit
	    			+ "</form>";
	    
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

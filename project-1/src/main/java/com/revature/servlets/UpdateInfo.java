package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.User;
import com.revature.dao.UsersDao;

/**
 * Servlet implementation class UpdateInfo
 */
public class UpdateInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String div = "<div class=\"w-25 form-floating mb-3\">";
		String endDiv = "</div>";
		
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		
		String uname = div
	    			+ "<input class=\"form-control\" type=text id=uname name=uname placeholder=" + user.getUsername() + ">"
	    			+ "<label for=uname>Username</label>"
	    			+ endDiv;
	
	    String pword = div
	    			+ "<input class=\"form-control\" type=password id=pword name=pword placeholder=" + user.getPassword() + ">"
	    			+ "<label for=pword>Password</label>"
	    			+ endDiv;
	
	    String fname = div
	    			+ "<input class=\"form-control\" type=text id=fname name=fname placeholder=" + user.getFirstName() + ">"
	    			+ "<label for=fname>First Name</label>"
	    			+ endDiv;
	
	    String lname = div
	    			+ "<input class=\"form-control\" type=text id=lname name=lname placeholder=" + user.getLastName() + ">"
	    	    	+ "<label for=lname>Last Name</label>"
	    			+ endDiv;
	
	    String email = div
	    			+ "<input class=\"form-control\" type=email id=email name=email placeholder=" + user.getEmail() + ">"
	    	    	+ "<label for=email>Email</label>"
	    			+ endDiv;
	    
	    String submit = div
	    			+ "<br> <button type=\"submit\" class=\"btn btn-secondary\"> Update </button>"
	    			+ endDiv;
	    
	    String form = "<form action=./UpdateInfo method=post class=\"bg-dark text-info pt-5 pb-5\">" + uname + pword + fname + lname + email + submit + "</form>";
	    
	    String content = form;
	    
	    String role = user.getRole();
	    String message = "WELCOME " + user.getFirstName() + " " + user.getLastName();
		request.setAttribute("message", message);
		request.setAttribute("content", content);
		getServletContext().getRequestDispatcher("/" + role.toLowerCase() + ".jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		
		String username = request.getParameter("uname").toUpperCase();
		String password = request.getParameter("pword");
		String firstName = request.getParameter("fname").toUpperCase();
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		user.setUsername(username.isEmpty() ? user.getUsername() : username);
		user.setPassword(password.isEmpty() ? user.getPassword() : password);
		user.setFirstName(firstName.isEmpty() ? user.getFirstName() : firstName);
		user.setLastName(lastName.isEmpty() ? user.getLastName() : lastName);
		user.setEmail(email.isEmpty() ? user.getEmail() : email);
		
		ud.updateUser(user);
		
		String role = user.getRole();
		String message = "WELCOME " + user.getFirstName() + " " + user.getLastName();
		request.setAttribute("message", message);
		request.setAttribute("content", "Information updated");
		getServletContext().getRequestDispatcher("/" + role.toLowerCase() + ".jsp").forward(request, response);
	}

}

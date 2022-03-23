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
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		
		String uname = "<label for=uname>Username</label> <br>"
	    			+ "<input type=text id=uname name=uname placeholder=" + user.getUsername() + "> <br> <br>";
	
	    String pword = "<label for=pword>Password</label> <br>"
	    			+ "<input type=password id=pword name=pword placeholder=" + user.getPassword() + "> <br> <br>";
	
	    String fname = "<label for=fname>First Name</label> <br>"
	    			+ "<input type=text id=fname name=fname placeholder=" + user.getFirstName() + "> <br> <br>";
	
	    String lname = "<label for=lname>Last Name</label> <br>"
	    			+ "<input type=text id=lname name=lname placeholder=" + user.getLastName() + "> <br> <br>";
	
	    String email = "<label for=email>Email</label> <br>"
	    			+ "<input type=email id=email name=email placeholder=" + user.getEmail() + "> <br> <br>";
	    
	    String submit = "<input type=submit value=Update>";
	    
	    String form = "<form action=./UpdateInfo method=post>" + uname + pword + fname + lname + email + submit + "</form>";
	    
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

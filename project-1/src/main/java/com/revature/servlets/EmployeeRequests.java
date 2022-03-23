package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Table;
import com.revature.User;
import com.revature.dao.UsersDao;
import com.revature.service.ManagerService;

/**
 * Servlet implementation class EmployeeRequests
 */
public class EmployeeRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRequests() {
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
		Table t = new Table();
		ManagerService ms = new ManagerService();
		
		String table = t.generateHTMLTable(ms.viewAllEmployees());
		
	    String reimb = "<label for=empid>Employee #</label> <br>"
	    				+ "<input type=text id=empid name=empid> <br> <br>";

	    String submit = "<input type=submit value=Submit>";
	    
	    String form = "<form action=./EmployeeRequests method=post>" + reimb + submit + "</form>";
	    
	    String content = table + form;
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
		Table t = new Table();
		ManagerService ms = new ManagerService();
		
		int empId = Integer.parseInt(request.getParameter("empid"));
		User u = ud.getUser(empId);
		String table = t.generateHTMLTable(ms.viewEmployeeRequests(u));
		
		String content = table;
	    String role = user.getRole();
	    String message = "WELCOME " + user.getFirstName() + " " + user.getLastName();
		request.setAttribute("message", message);
	    request.setAttribute("content", content);
		getServletContext().getRequestDispatcher("/" + role.toLowerCase() + ".jsp").forward(request, response);
	}

}

package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Table;
import com.revature.User;
import com.revature.dao.UsersDao;
import com.revature.service.EmployeeService;

/**
 * Servlet implementation class MyPendingRequests
 */
public class MyPendingRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPendingRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Table t = new Table();
		EmployeeService es = new EmployeeService();
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		
		String content = null;
		try {
			String table = t.generateHTMLTable(es.viewPendingRequests(user));
			content = table;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			content = "You have no pending reimbursement requests";
		}
		
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
		doGet(request, response);
	}

}

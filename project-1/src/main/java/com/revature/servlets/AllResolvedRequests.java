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
import com.revature.service.ManagerService;

/**
 * Servlet implementation class AllResolvedRequests
 */
public class AllResolvedRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllResolvedRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Table t = new Table();
		ManagerService ms = new ManagerService();
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		
		String content = null;
		try {
			String table = t.generateHTMLTable(ms.viewAllResolvedRequests());
			content = table;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			content = "There are no resolved reimbursement requests";
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

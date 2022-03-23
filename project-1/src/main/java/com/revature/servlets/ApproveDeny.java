package com.revature.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Reimbursement;
import com.revature.Table;
import com.revature.User;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UsersDao;
import com.revature.service.ManagerService;

/**
 * Servlet implementation class ApproveDeny
 */
public class ApproveDeny extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApproveDeny() {
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
		
		String table = t.generateHTMLTable(ms.viewAllPendingRequests());
		
	    String reimb = "<label for=reimb>Reimbursement #</label> <br>"
	    				+ "<input type=text id=reimb name=reimb> <br> <br>";
	    
	    String status = "<input type=radio id=approve name=status value=1 checked>"
					    + "<label for=approve>APPROVE</label> &nbsp; &nbsp;"
					    + "<input type=radio id=deny name=status value=2>"
					    + "<label for=deny>DENY</label> <br> <br>";

	    String submit = "<input type=submit value=Submit>";
	    
	    String form = "<form action=./ApproveDeny method=post>" + reimb + status + submit + "</form>";
	    
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
		Reimbursement r = new Reimbursement();
		ReimbursementDao rd = new ReimbursementDao();
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		
		int reimbId = Integer.parseInt(request.getParameter("reimb"));
		int statusId = Integer.parseInt(request.getParameter("status"));
		r = rd.getReimbursement(reimbId);
		r.setStatusId(statusId);
		r.setResolved();
		r.setResolverId(user.getId());
		rd.updateReimbursement(r);
		String status = statusId == 1 ? "APPROVED" : "DENIED";
		
		String content = "Reimbursement " + status;
	    String role = user.getRole();
	    String message = "WELCOME " + user.getFirstName() + " " + user.getLastName();
		request.setAttribute("message", message);
	    request.setAttribute("content", content);
		getServletContext().getRequestDispatcher("/" + role.toLowerCase() + ".jsp").forward(request, response);
	}

}

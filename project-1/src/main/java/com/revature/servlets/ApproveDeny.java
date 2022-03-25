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
		String div = "<div class=\"w-25 mb-3 text-left\">";
		String endDiv = "</div>";
		
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		Table t = new Table();
		ManagerService ms = new ManagerService();
		
		String content = null;
		try {
			String table = t.generateHTMLTable(ms.viewAllPendingRequests());
			
			String reimb = div
						+ "<label for=reimb>Reimbursement #: &emsp;</label>"
	    				+ "<input type=text id=reimb name=reimb required>"
						+ endDiv;
    
		    String status = div
		    				+ "<div class=\"form-check form-check-inline\">"
		    				+ "<input class=\"form-check-input\" type=radio id=approve name=status value=1 checked>"
						    + "<label class=\"form-check-label\" for=approve>APPROVE</label>"
		    				+ endDiv
		    				+ "<div class=\"form-check form-check-inline\">"
						    + "<input class=\"form-check-input\" type=radio id=deny name=status value=2>"
						    + "<label class=\"form-check-label\" for=deny>DENY</label>"
						    + endDiv + endDiv;
		
		    String submit = div
		    			+ "<button type=\"submit\" class=\"btn btn-secondary\"> Submit </button>"
		    			+ endDiv;
		    
		    String form = "<form action=./ApproveDeny method=post class=\"bg-dark text-info pt-5 pb-5\">" + reimb + status + submit + "</form>";
		    
			content = table + form;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			content = "There are no pending reimbursement requests";
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

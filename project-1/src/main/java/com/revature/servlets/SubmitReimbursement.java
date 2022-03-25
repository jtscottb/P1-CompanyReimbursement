package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.revature.Reimbursement;
import com.revature.User;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.UsersDao;

/**
 * Servlet implementation class SubmitReimbursement
 */
public class SubmitReimbursement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReimbursement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String div = "<div class=\"w-25 mb-3\">";
		String endDiv = "</div>";
		
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		
	    String amount = div
	    				+ "<label for=amount>Amount: &emsp;$</label>"
	    				+ "<input type=text id=amount name=amount>"
	    				+ endDiv;

	    String description = div
	    					+ "<label for=description class=\"form-label\">Description: &emsp;</label>"
	    					+ "<textarea class=\"form-control\" id=description name=description rows=\"3\"></textarea>"
	    					+ endDiv;

	    String type = div
	    			+ "<label for=type>Type: &emsp;</label>"
	    			+ "<select id=type name=type>"
	    			+ " <option value=1>Food</option>"
	    			+ " <option value=2>Lodging</option>"
	    			+ " <option value=3>Travel</option>"
	    			+ " <option value=4>Other</option>"
	    			+ "</select>"
	    			+ endDiv;

	    String image = div
	    			+ "<label for=image class=\"form-label\">Upload Receipt</label> <br>"
	    			+ "<input class=\"form-control\" type=file id=image name=image>"
	    			+ endDiv;

	    String submit = div
	    			+ "<br> <button type=\"submit\" class=\"btn btn-secondary\"> Submit </button>"
	    			+ endDiv;
	    
	    String form = "<form action=./SubmitReimbursement method=post class=\"bg-dark text-info pt-5 pb-5\">" + amount + description + type + image + submit + "</form>";
	    
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
		Reimbursement r = new Reimbursement();
		ReimbursementDao rd = new ReimbursementDao();
		
		InputStream is = null;
		r.setAmount(Double.parseDouble(request.getParameter("amount")));
		r.setDescription(request.getParameter("description"));
		r.setTypeId(Integer.parseInt(request.getParameter("type")));
//		Part photo = request.getPart("image");
//		if(photo != null) {
//			r.setImage(is = photo.getInputStream());
//		}
		r.setAuthorId(user.getId());
		r.setStatusId(3);
		r.setSubmitted();
		
		rd.addReimbursement(r);
		
		String role = user.getRole();
		String message = "WELCOME " + user.getFirstName() + " " + user.getLastName();
		request.setAttribute("message", message);
		request.setAttribute("content", "Reimbursement Submitted");
		getServletContext().getRequestDispatcher("/" + role.toLowerCase() + ".jsp").forward(request, response);
	}

}

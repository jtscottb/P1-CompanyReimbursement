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
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		
	    String amount = "<label for=amount>Amount</label> <br>"
	    				+ "<input type=text id=amount name=amount> <br> <br>";

	    String description = "<label for=description>Description</label> <br>"
	    					+ "<textarea id=description name=description></textarea> <br> <br>";

	    String type = "<label for=type>Type</label> <br>"
	    			+ "<select id=type name=type>"
	    			+ " <option value=1>Food</option>"
	    			+ " <option value=2>Lodging</option>"
	    			+ " <option value=3>Travel</option>"
	    			+ " <option value=4>Other</option>"
	    			+ "</select> <br> <br>";

	    String image = "<label for=image>Upload Receipt</label> <br>"
	    			+ "<input type=file id=image name=image> <br> <br>";

	    String submit = "<input type=submit value=Submit>";
	    
	    String form = "<form action=./SubmitReimbursement method=post>" + amount + description + type + image + submit + "</form>";
	    
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

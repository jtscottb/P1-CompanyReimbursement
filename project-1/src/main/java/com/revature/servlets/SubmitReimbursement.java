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
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		request.setAttribute("role", role.toUpperCase());
		request.setAttribute("message", message);
		request.setAttribute("js", role.toLowerCase() + ".js");
		request.setAttribute("content", "Reimbursement Submitted");
		getServletContext().getRequestDispatcher("/entry.jsp").forward(request, response);
	}

}

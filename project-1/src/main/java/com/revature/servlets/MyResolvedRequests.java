package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.Table;
import com.revature.User;
import com.revature.dao.UsersDao;
import com.revature.service.EmployeeService;

/**
 * Servlet implementation class MyResolvedRequests
 */
public class MyResolvedRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyResolvedRequests() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		Table t = new Table();
		EmployeeService es = new EmployeeService();
		UsersDao ud = new UsersDao();
		User user = ud.getCurrentUser();
		String table = t.generateHTMLTable(es.viewResolvedRequests(user));
		
		pw.write("<html>"
				+ "<head>\r\n"
				+ "		<meta charset=\"UTF-8\">\r\n"
				+ "		<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
				+ "		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "		<link rel=\"stylesheet\" href=\"./CSS/main.css\">\r\n"
				+ "		<script src=\"./JS/" + user.getRole().toLowerCase() + ".js\"></script>"
				+ "</head>"
				+ "<body onload=\"Load()\">"
				+ "		<div id=block>"
				+ "			<div id=choice></div>"
				+ "			<div id=selection>" + table + "</div>"
				+ "		</div>"
				+ "</body>"
				+ "</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

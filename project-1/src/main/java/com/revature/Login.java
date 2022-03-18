package com.revature;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String pword = request.getParameter("pword");
		
		PrintWriter pw = response.getWriter();
		
		File input = new File("./index.html");
        Document doc = Jsoup.parse(input,null);
        Element content = doc.getElementById("start");
        System.out.println(content.text("Hi How are you ?"));
        System.out.println(content.text());
        System.out.println(doc);
        
		String htmlResponse = "<html>";
        htmlResponse += "<h2>Your username is: " + uname + "<br/>";      
        htmlResponse += "Your password is: " + pword + "</h2>";    
        htmlResponse += "</html>";
         
        // return response
        pw.println(htmlResponse);
	}

}

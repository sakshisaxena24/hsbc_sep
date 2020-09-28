package com.facebookwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookwebapp.dao.facebookwebdao;
import com.facebookwebapp.dao.facebookwebdaointerface;
import com.facebookwebapp.entity.facebookwebentity;


public class Register extends HttpServlet {
	private facebookwebdaointerface fwd;
	private static final long serialVersionUID = 1L;
       
  public Register()
  {
	  fwd=new facebookwebdao();
  }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String n1 = request.getParameter("name");
		String n2 = request.getParameter("number");
		String n3 = request.getParameter("email");
		String n4 = request.getParameter("password");
		String n5 = request.getParameter("address");

	
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");
		out.println("Your name is " + n1);
		out.println("Your number is " + n2);
		out.println("Your Email is " + n3);
		out.println("Your password is " + n4);
		out.println("Your adress is " + n4);
		out.println("</body></html>");
		
		facebookwebentity em = new facebookwebentity();
		em.setName(n1);
		em.setNumber(n2);
		em.setEmail(n3);
		em.setPassword(n4);

		em.setAddress(n5);

		try {
			int i=fwd.registerEmployee(em);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("Registration successful   <a href=login.html>Contunue...</a>");
		
		out.println("Your Name is "+n1);
		out.println("<br>Your Password is "+n4);

		
	}

}

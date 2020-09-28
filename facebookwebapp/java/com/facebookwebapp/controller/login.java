package com.facebookwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookwebapp.dao.facebookwebdao;
import com.facebookwebapp.dao.facebookwebdaointerface;
import com.facebookwebapp.entity.facebookwebentity;

public class login extends HttpServlet {
	private facebookwebdaointerface fwd;
	private static final long serialVersionUID = 1L;
       
  public login()
  {
	  fwd=new facebookwebdao();
  }
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String n1=request.getParameter("name");
	//String n2=request.getParameter("address");
	String n4=request.getParameter("password");
	
	facebookwebentity em = new facebookwebentity();
em.setName(n1);
//em.setAddress(n2);
em.setPassword(n4);
	
boolean j = false;
try {
	j = fwd.loginprofile(em);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

response.setContentType("text/html");
PrintWriter out=response.getWriter();
out.println("<html><body>");
if(j)
{
	HttpSession ss=request.getSession(true);
	ss.setAttribute("userid",n1);
	//ss.setAttribute("address",n2);
	ss.setAttribute("pass",n4);
	
	out.println("welcome "+n1+"   <a href=TimeLine>timeline</a>   <a href=friends>friendlist</a>");
	
}
else {
	out.println("Invalid id and password");
	RequestDispatcher rd=getServletContext().getRequestDispatcher("/login.html");
	rd.include(request, response);
}
out.println("</body></html>");
}
	
	}



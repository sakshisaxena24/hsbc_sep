package com.facebookwebapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.facebookwebapp.dao.facebookwebdao;
import com.facebookwebapp.dao.facebookwebdaointerface;
import com.facebookwebapp.entity.facebookwebentity;


public class friends extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String name=request.getParameter("username");
		
		HttpSession ss=request.getSession(true);
		String name=ss.getAttribute("userid").toString();
		//String address=ss.getAttribute("address").toString();
		
		System.out.println(name);
		//System.out.println(address);
		
		facebookwebentity fe=new facebookwebentity();
		fe.setName(name);
		//fe.setName(address);
		
		facebookwebdaointerface fs=new facebookwebdao();
		List<facebookwebentity> i=fs.friendlistdao(fe);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html><body>");
		
		if(i.size()>0) {
			for(facebookwebentity ff:i) {
				out.println(ff.getName());
				out.println(ff.getAddress());
			}
		}
		else {
			out.println("no friend found");
		}
		
		out.println("</body></html>");
	}

}

package com.hsbc.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/RegisterSessionServlet")
public class RegisterSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public RegisterSessionServlet() {
        super();
   
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String username=request.getParameter("username");
		
	    String type=request.getParameter("type");
	    
	    long userid=Long.parseLong(request.getParameter("userid"));
	    
	    HttpSession httpSession=request.getSession(false);
		
		if(type.equals("buyer"))
			
		{
	       httpSession=request.getSession();
		   httpSession.setAttribute("username", username);
		   httpSession.setAttribute("type", type);
		   httpSession.setAttribute("userid", userid);
	
		   response.sendRedirect("buyerHomePage.jsp");
		}
		else
		{
			httpSession=request.getSession();
			httpSession.setAttribute("username", username);
			httpSession.setAttribute("type", type);
			httpSession.setAttribute("userid", userid);
		
			response.sendRedirect("sellerHomePage.jsp");

		}
	}

}

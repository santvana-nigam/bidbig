package com.hsbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class deregisterSessionServlet
 */
@WebServlet("/DeregisterSessionServlet")
public class DeregisterSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeregisterSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           PrintWriter  printWriter=response.getWriter();
		String param=request.getParameter("param");
		HttpSession httpSession=request.getSession(false);
		if(httpSession!=null) {
			
			   
			
			httpSession.invalidate();//will clear the data  in the cookie
			if(param.equals("buyer"))
				response.sendRedirect("loginBuyer.jsp");
			else if(param.equals("seller"))
			    response.sendRedirect("loginSeller.jsp");
			else
		        response.sendRedirect("home.jsp");
		}
		else
		{
			printWriter.println("Session Expired");
			
			
		}
	}

}

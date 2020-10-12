package com.hsbc.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.background.CheckUserExists;
import com.hsbc.dao.UserDAOImpl;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public LoginServlet() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      this.doPost(request, response);
	}


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		String referer = request.getHeader("Referer");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		   //System.out.println(referer);
	    String st[]=referer.split("/");
	    String refererpage=st[st.length-1];
	
	    UserDAOImpl daoImpl=new UserDAOImpl();
	    String type=daoImpl.getUserType(username);
	    //System.out.println(type);
		CheckUserExists u=new CheckUserExists();
		HttpSession httpSession=request.getSession(false);
	    long userid=0;
		if(u.ifexists(username, password))
		
		{
			System.out.println("user exist ");
			//will not  create session  if  it already exists
			


			if(httpSession!=null && httpSession.getAttribute("username")!=null)//if session exists
			{
				System.out.println("session exist");
			    type=(String)httpSession.getAttribute("type");
			   
				if(type.equals("seller"))
				{
					
					 response.sendRedirect("sellerProfile.jsp");
				}
				else
				{
					response.sendRedirect("buyerProfile.jsp");
				}
			}
			else//if there is no  ongoing session
			{
				//System.out.println("session does not exist");
				//System.out.println(refererpage);
				userid=daoImpl.getUserID(username);
				//String buyerid=null,sellerid=null;
				//if buyer details are entered in buyer login
				if(type.equals("buyer") && refererpage.equals("loginBuyer.jsp") )
				{
					//buyerid=Long.toString(userid);
					RequestDispatcher rd=request.getRequestDispatcher("RegisterSessionServlet?type=buyer&userid="+userid);  		
					rd.forward(request, response);
				}
				
				//if seller details are entered in seller login
				else if(type.equals("seller") && refererpage.equals("loginSeller.jsp") )
				{
					//sellerid=Long.toString(userid);
					RequestDispatcher rd=request.getRequestDispatcher("RegisterSessionServlet?type=seller&userid="+userid);  		
					rd.forward(request, response);
				}
				
				//if buyer details are entered in seller login
				else if(type.equals("buyer") && refererpage.equals("loginSeller.jsp") )
				{
					
					response.sendRedirect("loginBuyer.jsp");
				}
				
				//if seller details are entered in buyer login
				else if(type.equals("seller") && refererpage.equals("loginBuyer.jsp") )
				{
					
					response.sendRedirect("loginSeller.jsp");
				}
										
			}
		}
		else
		{
			/*
			 * System.out.println("user does not exist"); response.sendRedirect(referer);
			 */
			if(refererpage.equals("loginSeller.jsp"))
			   
			{
					
					RequestDispatcher rd=request.getRequestDispatcher("loginSeller.jsp");  	
					request.setAttribute("error", "Incorrect Seller Credentials ");
					rd.forward(request, response);
				}
				else
				{
					RequestDispatcher rd=request.getRequestDispatcher("loginBuyer.jsp");  	
					request.setAttribute("error", "Incorrect Buyer Credentials ");
					rd.forward(request, response);
				}
			}
			
		
		
		
		
	}

}

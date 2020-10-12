package com.hsbc.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.background.CheckUserExists;
import com.hsbc.dao.UserDAOImpl;
import com.hsbc.model.User;



@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		        PrintWriter out=response.getWriter();
				String referer = request.getHeader("Referer");
				String username=request.getParameter("username");
				String password=request.getParameter("password");
				String name=request.getParameter("name");
				String email=request.getParameter("email");
				String dob=request.getParameter("dob");
				
				String address=request.getParameter("address");
				long phone=Long.parseLong(request.getParameter("mobile"));
			   
			    //System.out.println(referer);
			    String st[]=referer.split("/");
			    String refererpage=st[st.length-1];
			    //System.out.println(refererpage);
				CheckUserExists u=new CheckUserExists();
			    UserDAOImpl daoImpl=new UserDAOImpl();
			   String type=null;
			   System.out.println(username);
				if(u.ifexists(username, password))
				{
					type=daoImpl.getUserType(username);
					if(type.equals("buyer"))
					{
						response.sendRedirect("buyerHomePage.jsp");
					}
					else
					{
						response.sendRedirect("sellerHomePage.jsp");
					}
					
				}
				else//if user does not exist
				{
					
					HttpSession httpSession=request.getSession(false);

					if(httpSession!=null && httpSession.getAttribute("username")!=null)//if session exists
					{
						System.out.println(refererpage);
					    type=(String)httpSession.getAttribute("type");
						if(type.equals("seller"))
						{
							
							 response.sendRedirect("sellerHomePage.jsp");
						}
						else
						{
							response.sendRedirect("buyerHomePage.jsp");
						}
					}
					else//if there is no ongoing session
					{
						
						if(refererpage.equals("registerBuyer.jsp") )
						{
							int year=Integer.parseInt(dob.substring(0,4));
							int currentyear=Integer.parseInt(LocalDate.now().toString().substring(0, 4));
							if(currentyear-year <21)
							{
								//response.sendRedirect(refererpage);
								RequestDispatcher rd=request.getRequestDispatcher("registerBuyer.jsp");  	
								request.setAttribute("error", "Age is less than 21 years");
								rd.forward(request, response);
							}
							else
							{
							
							User user=new User(daoImpl.getAll().size()+1, name, dob, phone, address,true, 0);
							if(daoImpl.insertCredentials(daoImpl.getAll().size()+1, password, email, username) && daoImpl.insertUser(user))
							{
							RequestDispatcher rd=request.getRequestDispatcher("RegisterSessionServlet?type=buyer&userid="+user.getUniqueId());  		
							rd.forward(request, response);
							}
							else
							{
								response.sendRedirect(refererpage);
							}
							}
						}
						else 
						{
							int year=Integer.parseInt(dob.substring(0,4));
							int currentyear=Integer.parseInt(LocalDate.now().toString().substring(0, 4));
							if(currentyear-year <21)
							{
								RequestDispatcher rd=request.getRequestDispatcher("registerSeller.jsp");  	
								request.setAttribute("error", "Age is less than 21 years");
								rd.forward(request, response);
							}
							else
							{
							User user=new User(daoImpl.getAll().size()+1, name, dob, phone, address,false, 0);
							if(daoImpl.insertCredentials(daoImpl.getAll().size()+1, password, email, username) && daoImpl.insertUser(user))
							{
							RequestDispatcher rd=request.getRequestDispatcher("RegisterSessionServlet?type=seller&userid="+user.getUniqueId());  		
							rd.forward(request, response);
							}
							else
							{
								response.sendRedirect(refererpage);
							}
							}
						}
						
						
						
						
						
						
						
						
					}
					
				}
	}

}

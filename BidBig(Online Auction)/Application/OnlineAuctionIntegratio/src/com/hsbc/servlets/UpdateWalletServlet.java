package com.hsbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.UserDAOImpl;
import com.hsbc.model.User;

/**
 * Servlet implementation class UpdateWalletServlet
 */
@WebServlet("/UpdateWalletServlet")
public class UpdateWalletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateWalletServlet() {
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
		
		HttpSession httpSession=request.getSession();
		long userid=(Long)httpSession.getAttribute("userid");
		double amount=Long.parseLong(request.getParameter("amount"));
		 UserDAOImpl daoImpl=new UserDAOImpl();
         User user=new User();
         user=daoImpl.getUserDetails(userid);
         double  totalamount=user.getWalletAmount()+amount;
         daoImpl.updatewallet(userid, totalamount);
         System.out.println(totalamount);
         response.sendRedirect("wallet.jsp");
	
	
	}

}

package com.hsbc.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.BidDAOImpl;
import com.hsbc.dao.CategoryDAOImpl;
import com.hsbc.dao.ProductDAOImpl;
import com.hsbc.enumm.BidStatusType;
import com.hsbc.model.Bid;
import com.hsbc.model.Product;

/**
 * Servlet implementation class CreateAuctionServlet
 */
@WebServlet("/CreateAuctionServlet")
public class CreateAuctionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateAuctionServlet() {
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
		
		HttpSession  httpSession=request.getSession(false);
		long productid = Long.parseLong(request.getParameter("productid"));
		double minbidvalue=Double.parseDouble(request.getParameter("minbidvalue"));
		String startdate=request.getParameter("startdate");
		String enddate=request.getParameter("enddate");
		

		BidDAOImpl bidDAOImpl=new BidDAOImpl();
		bidDAOImpl.insert(new Bid(bidDAOImpl.getAll().size()+1, productid, (Long)httpSession.getAttribute("userid"), minbidvalue, 0, 0, BidStatusType.valueOf("O"), startdate, enddate));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("sellerHomePage.jsp");
		requestDispatcher.forward(request, response);
	}

}

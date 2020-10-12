package com.hsbc.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.CategoryDAOImpl;
import com.hsbc.dao.ProductDAOImpl;
import com.hsbc.model.CategoryType;
import com.hsbc.model.Product;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
public class AddProductServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession httpSession=request.getSession(false);
		String productName = request.getParameter("productName");
		String categoryName = request.getParameter("productCategory");
		String productDescription = request.getParameter("productDescription");
		double productActualPrice = Double.parseDouble(request.getParameter("productActualPrice"));
		int productQuantity = Integer.parseInt(request.getParameter("productQuantity"));

		CategoryDAOImpl categoryDAOImpl = new CategoryDAOImpl();
		long categoryId = categoryDAOImpl.getCategoryByName(categoryName.toUpperCase());
		
		ProductDAOImpl productDAOImpl = new ProductDAOImpl();
		
		// get sellerId from session ---> talk to santvana
		productDAOImpl.insert(new Product(productDAOImpl.getAll().size()+1, categoryId,(Long)httpSession.getAttribute("userid") , productName, productDescription, productQuantity, productActualPrice));
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("sellerHomePage.jsp");
		requestDispatcher.forward(request, response);
	}

}

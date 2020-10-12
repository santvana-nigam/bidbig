package com.hsbc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.dao.BidDAOImpl;
import com.hsbc.dao.ParticipantDAOImpl;
import com.hsbc.model.Bid;
import com.hsbc.model.Participant;
import com.hsbc.model.ParticipationStatusType;

/**
 * Servlet implementation class PlaceBid
 */
@WebServlet("/PlaceBid")
public class PlaceBid extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceBid() {
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
		
		HttpSession httpSession=request.getSession(false);
		long bidid=Long.parseLong(request.getParameter("bidid"));
		double amount=Double.parseDouble(request.getParameter("amount"));
		///long userid=Long.parseLong((String)httpSession.getAttribute("userid"));
		ParticipantDAOImpl daoImpl=new ParticipantDAOImpl();
		Participant participant=new Participant(daoImpl.getAll().size()+1, amount,(Long)httpSession.getAttribute("userid"), bidid, ParticipationStatusType.valueOf("O"));
	///	Participant participant2=new Participant(participantId, bidValue, buyerId, bidId, participationStatusType)
		daoImpl.insert(participant);
		BidDAOImpl bidDAOImpl=new BidDAOImpl();
		Bid bid=new Bid();
		bid=bidDAOImpl.getBid(bidid);
		if(bid.getMaxBidValue()<amount)
		{
			int count=0;
			if((count=bid.getCount())>0)
			{
				bid.setCount(count++);
			}
			else
				bid.setCount(1);
		    bid.setMaxBidValue(amount);
		    bidDAOImpl.update(bidid, bid);
		}
		else
		{
			System.out.println("not if");
		}
		
		response.sendRedirect("buyerHomePage.jsp");
		
		
		
	}

}

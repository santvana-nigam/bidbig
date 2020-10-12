package com.hsbc.model;

import java.util.ArrayList;
import java.util.List;

import com.hsbc.dao.BidDAOImpl;
import com.hsbc.dao.ParticipantDAOImpl;

public class Buyer extends User{
	
	public Buyer() {
		// TODO Auto-generated constructor stub
	}
	
	public List<Bid> getAllParticipatedBids(long buyerid)
	{
		List<Bid> bids=new ArrayList<Bid>();
		List<Long> bidids=new ArrayList<Long>();
		ParticipantDAOImpl impl=new ParticipantDAOImpl();
		bidids=impl.getAllBidIdOfParticipant(buyerid);
		BidDAOImpl  bid=new  BidDAOImpl();
		
		for (Long b : bidids) {
			
			bids.add(bid.getBid(b));
		}
		return bids;
	}
	
	

}

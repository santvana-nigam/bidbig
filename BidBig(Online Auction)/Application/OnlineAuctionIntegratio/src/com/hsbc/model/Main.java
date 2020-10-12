package com.hsbc.model;

import java.util.ArrayList;
import java.util.List;

public class Main {

	
	public static void main(String[] args) {
		
		
		long buyerid=2;
		Buyer buyer=new Buyer();
		List<Bid> bids=new ArrayList<Bid>();
		List<Product> products=new ArrayList<Product>();
		bids=buyer.getAllParticipatedBids(buyerid);
		System.out.println(bids);
		
		
	}
}

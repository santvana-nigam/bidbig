package com.hsbc.dao;

import java.util.List;

import com.hsbc.model.Bid;

public interface DAO<T> {
	
	public void insert(T obj);
	public void remove(long id);
	public void update(long id, T obj);
	public List<T> getAll();
	//public List<Bid> getAllBidsAuctionedBy(int sellerId);
}

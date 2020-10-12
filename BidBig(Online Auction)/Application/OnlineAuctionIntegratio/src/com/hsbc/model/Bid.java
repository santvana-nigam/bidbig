package com.hsbc.model;

import com.hsbc.enumm.BidStatusType;

public class Bid {

	private long bidId;
	private long sellerId;
	private long productId;
	private BidStatusType statusOfBid;
	private String startDate;
	private String enddate;
	private double minBidValue;
	private double maxBidValue;
	private int count;
	
	public Bid() {
		// TODO Auto-generated constructor stub
	}
	public Bid(long bidId, long productId, long sellerId,double minBidValue, double maxBidValue,int count,
			BidStatusType statusOfBid, String startDate, String enddate ) {
		super();
		this.bidId = bidId;
		this.sellerId = sellerId;
		this.productId = productId;
		this.statusOfBid = statusOfBid;
		this.startDate = startDate;
		this.enddate = enddate;
		this.minBidValue = minBidValue;
		this.maxBidValue = maxBidValue;
		this.count = count;
	}
	public long getBidId() {
		return bidId;
	}
	public void setBidId(long bidId) {
		this.bidId = bidId;
	}
	public long getSellerId() {
		return sellerId;
	}
	public void setSellerId(int sellerId) {
		this.sellerId = sellerId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public BidStatusType getStatusOfBid() {
		return statusOfBid;
	}
	public void setStatusOfBid(BidStatusType statusOfBid) {
		this.statusOfBid = statusOfBid;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public double getMinBidValue() {
		return minBidValue;
	}
	public void setMinBidValue(double minBidValue) {
		this.minBidValue = minBidValue;
	}
	public double getMaxBidValue() {
		return maxBidValue;
	}
	public void setMaxBidValue(double maxBidValue) {
		this.maxBidValue = maxBidValue;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Bid [bidId=" + bidId + ", sellerId=" + sellerId + ", productId=" + productId + ", statusOfBid="
				+ statusOfBid + ", startDate=" + startDate + ", enddate=" + enddate + ", minBidValue=" + minBidValue
				+ ", maxBidValue=" + maxBidValue + ", count=" + count + "]";
	}

	
}

package com.hsbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.connection.DBConnection;
import com.hsbc.enumm.BidStatusType;
import com.hsbc.model.Bid;


public class BidDAOImpl implements DAO<Bid> {

	private DBConnection dbConnection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;

	public static final String insertQuery = "insert into bid(bidid,sellerId, productId, bidstatus, startDate, endDate, minBidValue, maxBidValue, participantcount) values(?,?,?,?,?,?,?,?,?)";
	public static final String selectQuery = "select * from bid";
	public static final String selectQueryWithStatus = "select * from bid where statusOfBid = ?";
	public static final String selectQueryBySellerId = "select * from bid where sellerId = ?";
	public static final String selectBidById = "select * from bid where bidId = ?";
	public static final String deleteBidQuery = "delete from bid where bidId = ?";
	public static final String updateBidQuery = "update bid set bidid = ?, sellerid = ?, productid = ?, bidstatus = ?, startdate = ?, enddate = ?, minbidvalue = ?, maxbidvalue = ?, participantcount = ? where bidId = ?";

	// public static final String = "insert into sample_bid values(?,?)";

	public BidDAOImpl() {
		// TODO Auto-generated constructor stub
		dbConnection = new DBConnection();
		preparedStatement = null;
		statement = null;
		resultSet = null;
	}

	@Override
	public void insert(Bid bid) {
		// TODO Auto-generated method stub
		try {
			int i = 0;
			preparedStatement = dbConnection.getPreparedStatement(insertQuery);
			 preparedStatement.setLong(++i, bid.getBidId());
			preparedStatement.setLong(++i, bid.getSellerId());
			preparedStatement.setLong(++i, bid.getProductId());
			preparedStatement.setString(++i, bid.getStatusOfBid().name());
			preparedStatement.setString(++i, bid.getStartDate());
			preparedStatement.setString(++i, bid.getEnddate());
			preparedStatement.setDouble(++i, bid.getMinBidValue());
			preparedStatement.setDouble(++i, bid.getMaxBidValue());
			preparedStatement.setInt(++i, bid.getCount());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void remove(long bidId) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = dbConnection.getPreparedStatement(deleteBidQuery);
			preparedStatement.setLong(1, bidId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void update(long bidId, Bid bid) {
		// TODO Auto-generated method stub
		preparedStatement = dbConnection.getPreparedStatement(updateBidQuery);
		try {
			preparedStatement.setLong(1, bid.getBidId());
			preparedStatement.setLong(2, bid.getSellerId());
			preparedStatement.setLong(3, bid.getProductId());
			preparedStatement.setString(4, bid.getStatusOfBid().name());
			preparedStatement.setString(5, bid.getStartDate());
			preparedStatement.setString(6, bid.getEnddate());
			preparedStatement.setDouble(7, bid.getMinBidValue());
			preparedStatement.setDouble(8, bid.getMaxBidValue());
			preparedStatement.setInt(9, bid.getCount());
			preparedStatement.setLong(10, bidId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Bid getBid(long bidId) {
		Bid temp = null;
		try {
			preparedStatement = dbConnection.getPreparedStatement(selectBidById);
			preparedStatement.setLong(1, bidId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			temp = new Bid(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3),
					 resultSet.getDouble(4), resultSet.getDouble(5),resultSet.getInt(6),
					 BidStatusType.valueOf(resultSet.getString(7)), resultSet.getString(8), resultSet.getString(9));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public List<Bid> getAll() {
		// TODO Auto-generated method stub
		try {
			preparedStatement = dbConnection.getPreparedStatement(selectQuery);
			resultSet = preparedStatement.executeQuery();
			List<Bid> tempBids = new ArrayList<>();
			while (resultSet.next()) {
				tempBids.add(new Bid(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3),
						 resultSet.getDouble(4), resultSet.getDouble(5),resultSet.getInt(6),
						 BidStatusType.valueOf(resultSet.getString(7)), resultSet.getString(8), resultSet.getString(9)));
			}
			return tempBids;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Bid> getAllBidsAuctionedBy(long sellerId) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = dbConnection.getPreparedStatement(selectQueryBySellerId);
			preparedStatement.setLong(1, sellerId);
			resultSet = preparedStatement.executeQuery();
			List<Bid> tempBids = new ArrayList<>();
			while (resultSet.next()) {
				tempBids.add(new Bid(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3),
						 resultSet.getDouble(4), resultSet.getDouble(5),resultSet.getInt(6),
						 BidStatusType.valueOf(resultSet.getString(7)), resultSet.getString(8), resultSet.getString(9)));

			}
			return tempBids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Bid> getAllBidsWithStatus(String status) {
		try {
			preparedStatement = dbConnection.getPreparedStatement(selectQueryWithStatus);
			preparedStatement.setString(1, status);
			resultSet = preparedStatement.executeQuery();
			List<Bid> tempBids = new ArrayList<>();
			while (resultSet.next()) {
				tempBids.add(new Bid(resultSet.getLong(1), resultSet.getLong(2), resultSet.getLong(3),
						 resultSet.getDouble(4), resultSet.getDouble(5),resultSet.getInt(6),
						 BidStatusType.valueOf(resultSet.getString(7)), resultSet.getString(8), resultSet.getString(9)));

			}
			return tempBids;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Bid> getAllActiveBids() {
		return this.getAllBidsWithStatus(BidStatusType.O.name());
	}

	public List<Bid> getAllNewBids() {
		return this.getAllBidsWithStatus(BidStatusType.N.name());
	}
}

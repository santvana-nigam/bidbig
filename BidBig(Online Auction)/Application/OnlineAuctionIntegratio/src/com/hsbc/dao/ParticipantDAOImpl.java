package com.hsbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.connection.DBConnection;
import com.hsbc.model.Participant;
import com.hsbc.model.ParticipationStatusType;

public class ParticipantDAOImpl implements DAO<Participant> {

	private DBConnection dbConnection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;

	public static final String insertQuery = "insert into participants values(?,?,?,?,?)";
	public static final String selectQuery = "select * from participant";
	public static final String selectQueryWithBidId = "select * from participants where bidid = ?";
	public static final String deleteBidQuery = "delete from participant where participantId = ?";
	public static final String updateParticipantQuery = "update participant set participantId = ?, bidValue = ?, buyerId = ?, bidId = ?, participationStatus = ? where participantId = ?";
	public static final String maxBidValueQuery = "select max(bidValue) from participant where bidId = ?";
	public static final String sortBidsWithBidValue = "select * from participant where bidId = ? order by bidValue desc";
	public static final String getBidIdForParticipant="select bidid from participants where buyerid=?";
	public static final String getParticipant="select * from participants where participationid=?";
	
	// public static final String = "insert into sample_bid values(?,?)";

	public ParticipantDAOImpl() {
		// TODO Auto-generated constructor stub
		dbConnection = new DBConnection();
		preparedStatement = null;
		statement = null;
		resultSet = null;
	}

	@Override
	public void insert(Participant obj) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = dbConnection.getPreparedStatement(insertQuery);
			preparedStatement.setLong(1, obj.getParticipantId());
			preparedStatement.setDouble(4, obj.getBidValue());
			preparedStatement.setLong(2, obj.getBuyerId());
			preparedStatement.setLong(3, obj.getBidId());
			preparedStatement.setString(5, obj.getParticipationStatusType().name());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERRRRRRRR");
		}

	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = dbConnection.getPreparedStatement(deleteBidQuery);
			preparedStatement.setLong(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(long id, Participant obj) {
		// TODO Auto-generated method stub
		preparedStatement = dbConnection.getPreparedStatement(updateParticipantQuery);
		try {
			preparedStatement.setLong(1, id);
			preparedStatement.setDouble(2, obj.getBidValue());
			preparedStatement.setLong(3, obj.getBuyerId());
			preparedStatement.setLong(4, obj.getBidId());
			preparedStatement.setString(5, obj.getParticipationStatusType().name());
			preparedStatement.setLong(6, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Participant> getAll() {
		List<Participant> temp = new ArrayList<Participant>();
		try {
			preparedStatement = dbConnection.getPreparedStatement("select * from participants");
			
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				temp.add(new Participant( rs.getLong("participationid"),rs.getDouble("bidvalue"),  rs.getLong("buyerid"), rs.getLong("bidid"),
						ParticipationStatusType.valueOf(rs.getString("auctionstatus"))));
			}
			//System.out.println(temp);
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRRRRRRR");
		}
		return null;
	}

	public List<Participant> getAllParticipantsOfBid(long bidId) {
		List<Participant> temp = new ArrayList<Participant>();
		try {
			preparedStatement = dbConnection.getPreparedStatement(selectQueryWithBidId);
			preparedStatement.setLong(1, bidId);
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				temp.add(new Participant( rs.getLong("participationid"),rs.getDouble("bidvalue"),  rs.getLong("buyerid"), rs.getLong("bidid"),
						ParticipationStatusType.valueOf(rs.getString("auctionstatus"))));
			}
			//System.out.println(temp);
			return temp;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("ERRRRRRRR");
		}
		return null;
	}
	
	public long getMaxBidValue(int bidId) {
		try {
			preparedStatement = dbConnection.getPreparedStatement(maxBidValueQuery);
			preparedStatement.setInt(1, bidId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			return resultSet.getLong(1);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public List<Participant> getListSortedWithBidValue(int bidId){
		
		List<Participant> temp = new ArrayList<Participant>();
		try {
			preparedStatement = dbConnection.getPreparedStatement(sortBidsWithBidValue);
			preparedStatement.setInt(1, bidId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				temp.add(new Participant(resultSet.getLong("participationid"), resultSet.getLong(2), resultSet.getInt(3),
						resultSet.getInt(4), ParticipationStatusType.valueOf(resultSet.getString(5))));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}
	
	public List<Long>  getAllBidIdOfParticipant(long buyerid)
	{
		
		
		List<Long> bidids=new ArrayList<Long>();
		try
		{
			preparedStatement=dbConnection.getPreparedStatement(getBidIdForParticipant);
			preparedStatement.setLong(1, buyerid);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				bidids.add(resultSet.getLong("bidid"));
			}
			return bidids;
			
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public Participant getParticipant(long participantid)
	{
		Participant participant=null;
		preparedStatement=dbConnection.getPreparedStatement(getParticipant);
		try {
			preparedStatement.setLong(1, participantid);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				participant=new Participant(rs.getLong("participationid"), rs.getDouble("bidvalue"),  rs.getLong("buyerid"), rs.getLong("bidid"),
						ParticipationStatusType.valueOf(rs.getString("auctionstatus")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("get product error");
			e.printStackTrace();
		}
		return participant;
	}


}

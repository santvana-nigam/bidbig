package com.hsbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.connection.DBConnection;
import com.hsbc.model.User;

public class UserDAOImpl implements DAO<User> {

	private DBConnection dbConnection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;

	public static final String insertQuery = "insert into user(userid,fullname, dateOfBirth, phone, address, type, wallet) values(?,?,?,?,?,?,?)";
	public static final String selectQuery = "select * from user";
	public static final String selectQueryWithUserId = "select * from user where userId = ?";
	public static final String deleteUserQuery = "delete from user where userId = ?";
	public static final String updateUserQuery = "update user set userId = ?, name = ?, dateOfBirth = ?, phoneNo = ?, address = ?, userType = ?, walletAmount = ? where userId = ?";
	public static final  String getPassword="select password from usercredentials where username=?";
	public static final  String getType="select type from user inner join usercredentials on user.userid = usercredentials.userid where usercredentials.username=?";
	// public static final String = "insert into sample_bid values(?,?)";
	public static  final String getID="select userid from usercredentials where username=?";
	public  static final String insertcredentials="insert into  usercredentials values(?,?,?,?)";

	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
		dbConnection = new DBConnection();
		preparedStatement = null;
		statement = null;
		resultSet = null;
	}

	@Override
	public void insert(User obj) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = dbConnection.getPreparedStatement(insertQuery);
			preparedStatement.setLong(1, obj.getUniqueId());
			preparedStatement.setString(2, obj.getName());
			preparedStatement.setString(3, obj.getDateOfBirth());
			preparedStatement.setLong(4, obj.getPhoneNo());
			preparedStatement.setString(5, obj.getAddress());
			preparedStatement.setInt(6, obj.isUserType()?1:0);
			preparedStatement.setDouble(7, obj.getWalletAmount());
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean insertUser(User obj) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = dbConnection.getPreparedStatement(insertQuery);
			preparedStatement.setLong(1, obj.getUniqueId());
			preparedStatement.setString(2, obj.getName());
			preparedStatement.setString(3, obj.getDateOfBirth());
			preparedStatement.setLong(4, obj.getPhoneNo());
			preparedStatement.setString(5, obj.getAddress());
			preparedStatement.setInt(6, obj.isUserType()?1:0);
			preparedStatement.setDouble(7, obj.getWalletAmount());
			preparedStatement.executeUpdate();
			
			
			return true;
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean insertCredentials(long userid,String password,String email,String username)
	{
		try
		{
			preparedStatement=dbConnection.getPreparedStatement(insertcredentials);
			preparedStatement.setLong(1, userid);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, password);
			preparedStatement.setString(4, username);
			preparedStatement.executeUpdate();
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, User obj) {
		// TODO Auto-generated method stub
		try {
			preparedStatement = dbConnection.getPreparedStatement(updateUserQuery);
			preparedStatement.setLong(1, obj.getUniqueId());
			preparedStatement.setString(2, obj.getName());
			preparedStatement.setString(3, obj.getDateOfBirth());
			preparedStatement.setLong(4, obj.getPhoneNo());
			preparedStatement.setString(5, obj.getAddress());
			preparedStatement.setInt(6, obj.isUserType()?1:0);
			preparedStatement.setDouble(7, obj.getWalletAmount());
			preparedStatement.setLong(8, id);
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		List<User> temp = new ArrayList<User>();
		try {
			preparedStatement = dbConnection.getPreparedStatement(selectQuery);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				temp.add(new User(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getLong(4), resultSet.getString(5), (resultSet.getInt(6)==1)?true:false, resultSet.getDouble(7)));
				
				//User user=new User(uniqueId, name, dateOfBirth, phoneNo, address, userType, walletAmount)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}
	
	public User getUserDetails(long userId) {
		User temp = null;
		try {
			preparedStatement = dbConnection.getPreparedStatement(selectQueryWithUserId);
			preparedStatement.setLong(1, userId);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				temp = new User(resultSet.getLong("userid"), resultSet.getString("fullname"), resultSet.getString("dateofbirth"),
						resultSet.getLong("phone"), resultSet.getString("address"), resultSet.getBoolean("type"), resultSet.getLong("wallet"));
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return temp;
	}
	
	
	public String getPassword(String username)
	{
		String password=null;
        try
        {
        	preparedStatement=dbConnection.getPreparedStatement(getPassword);
        	preparedStatement.setString(1, username);
        	ResultSet rs=preparedStatement.executeQuery();
        	while(rs.next())
        	{
        		password=rs.getString(1);
        	}
        	
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        return password;
	}
	
	
	  public String getUserType(String username) {
		  int type=0;
		  try 
		  {
	  preparedStatement=dbConnection.getPreparedStatement(getType);
	  preparedStatement.setString(1, username); ResultSet
	  rs=preparedStatement.executeQuery();
	  while(rs.next()) 
	  { 
		  type=rs.getInt(1);
		  
	  }
	  if(type==1)
		  return "buyer";
	  else
		  return "seller";
	  
	  } catch (Exception e) 
		  
		  { e.printStackTrace();
	  
	  } 
		  return null;
 }
	 
	
	public long getUserID(String username) {
		long userid=0;
        try
        {
        	preparedStatement=dbConnection.getPreparedStatement(getID);
        	preparedStatement.setString(1, username);
        	ResultSet rs=preparedStatement.executeQuery();
        	while(rs.next())
        	{
        		userid=rs.getLong(1);
        	}
        	
        }
        catch (Exception e) {
			e.printStackTrace();
		}
        return userid;
	}
	
	
	public void updatewallet(long userid,double amount)
	{
		try
        {
        	preparedStatement=dbConnection.getPreparedStatement("update user set wallet=? where userid=?");
        	preparedStatement.setDouble(1, amount);
        	preparedStatement.setLong(2,userid);
        	preparedStatement.execute();
        	
        }
        catch (Exception e) {
			e.printStackTrace();
		}
       
	}

}

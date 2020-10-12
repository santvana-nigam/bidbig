package com.hsbc.dao;

import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.connection.DBConnection;
import com.hsbc.enumm.BidStatusType;
import com.hsbc.model.Bid;
import com.hsbc.model.Product;

public class ProductDAOImpl implements DAO<Product>{

	
	private DBConnection dbConnection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;
	
	public static  final  String insertQuery="insert into product(productid,catid,sellerid,name,description,quantity,actualprice) values(?,?,?,?,?,?,?)";
	
	public static final  String getProduct="select *  from product where productid=?";
    public ProductDAOImpl() {
		// TODO Auto-generated constructor stub
				dbConnection = new DBConnection();
				preparedStatement = null;
				statement = null;
				resultSet = null;
	}
	
	@Override
	public void insert(Product obj) {

		preparedStatement=dbConnection.getPreparedStatement(insertQuery);
		try {
			preparedStatement.setLong(1, obj.getProdID());
			preparedStatement.setLong(2, obj.getCatID());
			preparedStatement.setLong(3, obj.getSellerID());
			preparedStatement.setString(4, obj.getName());
			preparedStatement.setString(5, obj.getDescription());
			preparedStatement.setInt(6, obj.getQuantity());
	
			preparedStatement.setDouble(7, obj.getActualPrice());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(long id, Product obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
				try {
					preparedStatement = dbConnection.getPreparedStatement("select * from product");
					ResultSet rs = preparedStatement.executeQuery();
					List<Product> tempBids = new ArrayList<>();
					while (rs.next()) {
						tempBids.add(new Product(rs.getLong("productid"), rs.getLong("catid"), rs.getLong("sellerid"),
								rs.getString("name"), rs.getString("description"), rs.getInt("quantity"), 
								rs.getDouble("actualprice")));
					}
					return tempBids;
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
	}
	
	
	public Product getProduct(long productid)
	{
		Product product=null;
		preparedStatement=dbConnection.getPreparedStatement(getProduct);
		try {
			preparedStatement.setLong(1, productid);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				product=new Product(productid, rs.getLong("catid"), rs.getLong("sellerid"),
						rs.getString("name"), rs.getString("description"), rs.getInt("quantity"), 
						rs.getDouble("actualprice"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("get product error");
			e.printStackTrace();
		}
		return product;
	}
	
	public List<Product> getProductBySellerId(long sellerid)
	{
		List<Product> product=new ArrayList<Product>();
		preparedStatement=dbConnection.getPreparedStatement("select * from product where sellerid=?");
		try {
			preparedStatement.setLong(1, sellerid);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next())
			{
				product.add(new Product(rs.getLong("productid"), rs.getLong("catid"), rs.getLong("sellerid"),
						rs.getString("name"), rs.getString("description"), rs.getInt("quantity"), 
						rs.getDouble("actualprice")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("get product error");
			e.printStackTrace();
		}
		return product;
	}




	
	
	

}

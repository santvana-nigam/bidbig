package com.hsbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.hsbc.connection.DBConnection;
import com.hsbc.model.Category;
import com.hsbc.model.CategoryType;

public class CategoryDAOImpl implements DAO<Category> {

	private DBConnection dbConnection;
	private PreparedStatement preparedStatement;
	private Statement statement;
	private ResultSet resultSet;

	public static final String selectCategoryByName = "select * from category where name = ?";

	public CategoryDAOImpl() {
		// TODO Auto-generated constructor stub
		dbConnection = new DBConnection();
		preparedStatement = null;
		statement = null;
		resultSet = null;
	}

	@Override
	public void insert(Category obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(long id, Category obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public long getCategoryByName(String categoryType) {
		Category temp = null;
		String category =categoryType;

		try {
			preparedStatement = dbConnection.getPreparedStatement(selectCategoryByName);
			preparedStatement.setString(1, category);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next())
			{
				temp = new Category(resultSet.getLong(1), resultSet.getString(2), resultSet.getString(3));
			}
			
			System.out.println(temp);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (temp.getCategoryId());
	}
}

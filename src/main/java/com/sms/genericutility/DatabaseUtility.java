package com.sms.genericutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.Driver;

/**
 *  This class contains reusable methods which is used for creating the data,reading the data,updating the data,
 *  and deleting the data from my sql database.
 *  @author Deepak Patil. 
 */

public class DatabaseUtility {

	Connection connection;
	Statement  statement;
	Driver dbDriver;
	
	/**
	 * this method is use to Setting up the connection with database.
	 * @param url
	 * @param un
	 * @param pwd
	 */
	public void getDataBaseConnection(String url, String un, String pwd)
	{
		try {
		dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		 connection = DriverManager.getConnection(url,un,pwd);
		  statement = connection.createStatement();
	}
		catch(SQLException e)
		{
			
		}
	}
	
	/**
	 * This method will be use to retriving the data from database
	 * @param column_name
	 * @param query
	 * @return
	 */
	public String executeQuery(String column_name, String query)
	{
		try {
		ResultSet result = statement.executeQuery(query);
		while(result.next())
			{
			column_name=result.getString(column_name);
			}
		}
		catch(SQLException e)
		{
			
		}
	return column_name;
	}	
	
	
	/**
	 * This method will be used in order to insert/store/modify/delete the data into the database.
	 * @param query
	 * @return
	 */
	public void setDataInDataBase(String query)
	{
	
		try {
		int result = statement.executeUpdate(query);
		if(result==1)
			System.out.println("data updated in database successfully");
		}
	catch(SQLException e)
	{
		System.out.println("data is not updated into database");
	}

	}	
	
	/**
	 * This method will be use in order to close the database connection.
	 */
	public void closeDatabase()
	{
		try {
		connection.close();
	}
		catch(SQLException e)
		{
			
		}
	}	
	
	/**
	 * This method will be used in order to retrieve / fetch the data from database
	 * @param query
	 * @param columnName
	 * @return
	 */
	public ArrayList<String> getDataFromDataBase(String query,String columnName)
	{
		ArrayList<String> list=new ArrayList<>();
		try {
		ResultSet result = statement.executeQuery(query);
			while(result.next())
			{
			list.add(result.getString(columnName));
			}
		}
		catch(SQLException e)
		{
			
		}
			
		return list;
	}
	
	
	
}





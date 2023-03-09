package edu.properties.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataInsertToDatabase {

	public static void main(String[] args) throws SQLException {

		Connection connection=null;
		try {
		
				Driver dbDriver=new Driver();
				DriverManager.registerDriver(dbDriver);
				
				 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46","root","root");
				
				Statement statement = connection.createStatement();
				
				int result = statement.executeUpdate("insert into employee values (103, 'sachin',70000,12345,'dehli')");
				
				
				
				if(result==1)
				{
					System.out.println("user is created!");
				}
				else
				{
					System.out.println("user is not created!");
				}
		}
		catch(Exception e)
		{
			System.out.println("exception is handled!");
			
		}
			finally
			{
				connection.close();
				System.out.println("connection closed!");
			}

	}

}

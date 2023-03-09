package edu.properties.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DeleteDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		
		Connection connection=null;
		try {
		
				Driver dbDriver=new Driver();
				DriverManager.registerDriver(dbDriver);
				
				 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46","root","root");
				
				Statement statement = connection.createStatement();
				
				int result = statement.executeUpdate("delete from employee where emp_id=101");
				
				
				
				if(result==1)
				{
					System.out.println("user data is deleted!");
				}
				else
				{
					System.out.println("user data is not deleted!");
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

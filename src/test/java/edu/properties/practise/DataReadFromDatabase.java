 package edu.properties.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataReadFromDatabase {

	public static void main(String[] args) throws SQLException {
		
		// Step 1 :- Creating thv e instance for driver and register the driver to jdbc(java database connectivity).
		
		Driver dbDriver=new Driver();
		DriverManager.registerDriver(dbDriver);
		
		// Step 2 :- connecting with mysSQL database inorder to perform "CRUD", Get connection (database url , db username, db password)
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet46","root","root");
		
		// step 3 :- Create a statement
		Statement statement = connection.createStatement();
		
		// Step 4 :- ExecuteQuery
		ResultSet result = statement.executeQuery("select * from employee");
		
		// Step 5 :- iterate the data from set
		
		while(result.next())
		{
			String empName = result.getString("emp_name");
			String empid = result.getString("emp_id");
			System.out.println(empName+"====>"+empid);
			
		}
		
		// Step 6 :- Close the connection.
		
		connection.close();
	}

}
 
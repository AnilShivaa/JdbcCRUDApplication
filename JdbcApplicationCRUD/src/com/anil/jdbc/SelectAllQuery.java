package com.anil.jdbc;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class SelectAllQuery {

	public static void main(String[] args)throws SQLException {
		
		//step 1
		oracle.jdbc.driver.OracleDriver driver=new oracle.jdbc.driver.OracleDriver();
		
		//step 2
		DriverManager.registerDriver(driver);
		
		//step 3
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "anil", "anilg");
		
		//step 4
		Statement st=con.createStatement();
		
		//step 5
			//SELECT * FROM STUDENT
		String query="SELECT * FROM STUDENT";
		
		//step 6
		ResultSet rs=st.executeQuery(query);
		//taking each data from resultSet
		while(rs.next()==true) {
			System.out.println(rs.getString(1) +" "+rs.getString(2) +" "+ rs.getString(3));
		}
		
		rs.close();
		st.close();
		con.close();
	} 
}

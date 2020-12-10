package com.anil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class DeleteDataUsingWhere {

	public static void main(String[] args) throws SQLException {
		
		//taking user input
				Scanner sc=new Scanner(System.in);
				
				System.out.println("Enter student number");
				int studentNo=sc.nextInt();
			
				
				//1.creating driver
				oracle.jdbc.driver.OracleDriver driver=new OracleDriver();
					
				//2.registering driver using driverManager()
				DriverManager.registerDriver(driver);
				
				//3. connecting to database
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "anil", "anilg");
				
				//4. creating statment obj
				Statement st=con.createStatement();
				
				//preparing query
					//delete from student where sno=8;
				String query="delete from student where sno="+studentNo;
				System.out.println(query);
				
				//executing query
				int count=st.executeUpdate(query);
				
				if(count==0) {
					System.out.println("Unable to Delete");
				}
				else {
					System.out.println("Deleted records where SNO="+studentNo);
				}
				st.close();
				con.close();

	}

}

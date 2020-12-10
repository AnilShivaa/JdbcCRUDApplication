package com.anil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.jdbc.driver.OracleDriver;

public class InsertIntoDatabase {

	public static void main(String[] args) throws SQLException {
		
		
		//taking user input
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter student number");
		int studentNo=sc.nextInt();
		
		System.out.println("Enter student Name");
		String studentName=sc.next();
		
		System.out.println("Enter student Address");
		String studentAddress=sc.next();
		
		//adding '' quote in variable
		studentName="'"+studentName+"'";
		studentAddress="'"+studentAddress+"'";
		
		//1.creating driver
		oracle.jdbc.driver.OracleDriver driver=new OracleDriver();
			
		//2.registering driver using driverManager()
		DriverManager.registerDriver(driver);
		
		//3. connecting to database
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "anil", "anilg");
		
		//4. creating statment obj
		Statement st=con.createStatement();
		
		//preparing query
		String query="insert into student values("+studentNo+","+studentName+","+studentAddress+")";
		System.out.println(query);
		
		//executing query
		int count=st.executeUpdate(query);
		
		if(count==0) {
			System.out.println("Unable to insert");
		}
		else {
			System.out.println("Inserted SNO="+studentNo+" "+"SName="+studentName+" "+"SAddress="+studentAddress);
		}
		st.close();
		con.close();
	}
	
}

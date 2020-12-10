package com.anil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import oracle.net.aso.n;


public class SelectQueryUsingWhere {

	public static void main(String[] args) throws SQLException {
		
		Scanner sc=new Scanner(System.in);
		
		//taking user input
		System.out.println("Enter student name");
		//int studentNo=sc.nextInt();
		String name=sc.next();
		name="'"+name+"'";
		
				//step 1
				oracle.jdbc.driver.OracleDriver driver=new oracle.jdbc.driver.OracleDriver();
				
				//step 2
				DriverManager.registerDriver(driver);
				
				//step 3
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "anil", "anilg");
				
				//step 4
				Statement st=con.createStatement();
				
				//step 5
					//SELECT SNO,SNAME,SADD FROM STUDENT WHERE SNAME='anil';
				
				String query="SELECT SNO,SNAME,SADD FROM STUDENT WHERE SNAME="+name;
				System.out.println(query);
				
				//step 6
				ResultSet rs=st.executeQuery(query);
				//taking each data from resultSet
					//checking data is there or not
				boolean isThereDataFlag=false;
				while(rs.next()!=false) {
					isThereDataFlag=true;
					System.out.println(rs.getString(1) +" "+rs.getString(2) +" "+ rs.getString(3));
				}
				if(isThereDataFlag==false) {
					System.out.println("Data "+name+" No record found");
				}
				else {
					System.out.println("Data "+name+" Found and display");
				}
				rs.close();
				st.close();
				con.close();
	}
	
}

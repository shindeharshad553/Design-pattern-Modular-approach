package com.dao.modularApproach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

//This class contains all the methods for all the database related operations 
public class databaseOperations {
	public Connection con;

	public databaseOperations() {
		try {
//		load and register the driver
			Class.forName("com.mysql.cj.jdbc.Driver");

//		make the connection 
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertData() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name : ");
		String name = sc.next();
		System.out.println("Enter city : ");
		String city = sc.next();
		PreparedStatement ps = con.prepareStatement("Insert into student (name,address) values(?,?)");
		ps.setString(1, name);
		ps.setString(2, city);
		ps.executeUpdate();
		System.out.println("data inserted successfully!!!");
		sc.close();
	}

	public void updateData() throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to update : ");
		int id = sc.nextInt();

		System.out.println("Enter new name to set : ");
		String name = sc.next();
		PreparedStatement ps = con.prepareStatement("update student set name=? where id=?");
		ps.setString(1, name);
		ps.setInt(2, id);
		ps.executeUpdate();
		System.out.println("Data Updated Sucessfully!!!!");
		sc.close();
	}

	public void deleteData() throws SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id to delete : ");
		int id = sc.nextInt();

		PreparedStatement ps = con.prepareStatement("delete from student where id=?");
		ps.setInt(1, id);
		ps.executeUpdate();
		System.out.println("Data deleted Sucessfully!!!!");
		sc.close();
	}

	public void fetchData() throws SQLException {
		PreparedStatement ps = con.prepareStatement("select * from student");
		ResultSet rs = ps.executeQuery();
		System.out.println("Fetching student records .......");
		while (rs.next())
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
	}
}

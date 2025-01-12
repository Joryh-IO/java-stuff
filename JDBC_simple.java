package com.LearnSql;
import java.sql.*;


public class Main {

	public static void main(String[] args) {
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String USERNAME = "root";
		String PASSWORD = "xxxxxxx";
		String DATABASE = "xxxxxxx";
		String SERVER = "jdbc:mysql://localhost:3306/";
		try {
		// TODO assign driver to class name
		Class.forName(DRIVER);
		// TODO start a connection
		Connection con = DriverManager.getConnection(SERVER+DATABASE,USERNAME,PASSWORD);
		System.out.println("Connection established");
		// TODO create statement
		String Query = "INSERT INTO trail_name(person_name)Values(?);";
		PreparedStatement QueryStatement = con.prepareStatement(Query);
		QueryStatement.setString(1, "Carlos");
		// TODO execute query
		int i = QueryStatement.executeUpdate();
		if(i>0)System.out.println("Query Executed !");
		else System.out.println("Query Failed....");
		con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}

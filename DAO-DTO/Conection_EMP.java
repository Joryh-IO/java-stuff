import java.sql.*;
public class Conection_EMP {
	/*
	 * This file sole purpose is to establish connection and during initialization it returns
	 * a connection.
	 */
	public static Connection getCon()throws Exception {
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String USERNAME = "root";
		String PASSWORD = "Sujeeth123";
		String DATABASE = "Bogota";
		String SERVER = "jdbc:mysql://localhost:3306/";
		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(SERVER+DATABASE,USERNAME,PASSWORD);
		return con;
	}
}

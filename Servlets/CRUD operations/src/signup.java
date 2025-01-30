package com.mumbai;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/signup")
public class SignUp extends HttpServlet {
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String USERNAME = "root";
	String PASSWORD = "XXXXXXX";
	String DATABASE = "XXXXXXX";
	String SERVER = "jdbc:mysql://localhost:3306/";
	private static final long serialVersionUID = 1L;
       

    public SignUp() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user  = request.getParameter("username");
		String pwd = request.getParameter("password");
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(SERVER+DATABASE,USERNAME,PASSWORD);
			String query = "SELECT * FROM userList WHERE username=? AND password=?";
			PreparedStatement queryStatement = con.prepareStatement(query);
			queryStatement.setString(1, user);
			queryStatement.setString(2,pwd);
			ResultSet rs = queryStatement.executeQuery();
			if(rs.next()) {
				System.out.println("User exist!");
				request.getRequestDispatcher("dashboard.jsp").include(request, response);
			}
			else {
				System.out.println("Cant find user..");
				query = "INSERT INTO userList(username,password)VALUES(?,?);";
				PreparedStatement queryStatement2 = con.prepareStatement(query);
				queryStatement2.setString(1, user);
				queryStatement2.setString(2,pwd);
				int i = queryStatement2.executeUpdate();
				if(i>0) {
					System.out.println("User data entered");
					request.getRequestDispatcher("dashboard.jsp").include(request, response);
				}
				else {
					System.out.println("Failed to enter user data");
					request.getRequestDispatcher("index.html").include(request, response);
				}
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

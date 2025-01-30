package com.mumbai;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


@WebServlet("/dashboard")
public class Dashboard extends HttpServlet {
	String DRIVER = "com.mysql.cj.jdbc.Driver";
	String USERNAME = "XXXXXXX";
	String PASSWORD = "XXXXXXX";
	String DATABASE = "Bogota";
	String SERVER = "jdbc:mysql://localhost:3306/";
	private static final long serialVersionUID = 1L;

    public Dashboard() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<User> al = new ArrayList<User>();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("password");
		String option = request.getParameter("option");
		
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(SERVER+DATABASE,USERNAME,PASSWORD);
			String query = "SELECT * FROM userList;";
			PreparedStatement q = con.prepareStatement(query);
			ResultSet rs = q.executeQuery();
			
			while(rs.next()) {
				int rs_id = rs.getInt("id");
				String rs_username = rs.getString("username");
				String rs_password =rs.getString("password");
				User a = new User(rs_id, rs_username, rs_password);
				al.add(a);
			};
			
		}catch(Exception e) {
			System.out.println(e);
		}
		request.setAttribute("users", al);
		request.getRequestDispatcher("dashboard.jsp").include(request, response);
	
		if(option.equals("update")) {
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(SERVER+DATABASE,USERNAME,PASSWORD);
				String query = "UPDATE userList SET password=? WHERE id=?";
				PreparedStatement q = con.prepareStatement(query);
				q.setString(1, password);
				q.setInt(2, id);
				int i = q.executeUpdate();
				if(i>0) {
					System.out.println("updated");
					request.getRequestDispatcher("dashboard.jsp").include(request, response);
				}
				else {
					System.out.println("error updating");
					request.getRequestDispatcher("dashboard.jsp").include(request, response);
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		}else if(option.equals("delete")) {
			try {
				Class.forName(DRIVER);
				Connection con = DriverManager.getConnection(SERVER+DATABASE,USERNAME,PASSWORD);
				String query = "DELETE FROM userList WHERE id=?";
				PreparedStatement q = con.prepareStatement(query);
				q.setInt(1, id);
				int i = q.executeUpdate();
				if(i>0) {
					System.out.println("deleted");
					request.getRequestDispatcher("dashboard.jsp").include(request, response);
				}
				else {
					System.out.println("error deleting");
					request.getRequestDispatcher("dashboard.jsp").include(request, response);
				}
			}catch(Exception e) {
				System.out.println(e);
			}
		}else {
			//Do nothing
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

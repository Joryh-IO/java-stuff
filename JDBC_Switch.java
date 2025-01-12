import java.sql.*;
import java.io.*;
import java.util.*;


public class Main_B {
	public static void main(String [] args) {
		String DRIVER = "com.mysql.cj.jdbc.Driver";
		String USERNAME = "root";
		String PASSWORD = "xxxxxxxx";
		String DATABASE = "xxxxxxxx";
		String SERVER = "jdbc:mysql://localhost:3306/";
		
		
		System.out.println("Welcome to Sql connection....");
		try {
			Class.forName(DRIVER);
			Connection con = DriverManager.getConnection(SERVER+DATABASE, USERNAME, PASSWORD);
			System.out.println("Connection established....");
			Boolean Run = true;
			do {
				System.out.println("1.Insert"
						+ "\n2.Delete"
						+ "\n3.Update"
						+ "\n4.Print all");
				System.out.print("Enter choice: ");
				Scanner sc = new Scanner(System.in);
				int choice = sc.nextInt();
				switch(choice) {
				case 1: {
					String query = "INSERT INTO trail_name (person_name)VALUES(?);";
					PreparedStatement queryStatement = con.prepareStatement(query);
					System.out.print("enter name: ");
					String n = sc.next();
					queryStatement.setString(1, n);
					System.out.println(" ---->#");
					int r = queryStatement.executeUpdate();
					if(r>0)System.out.println("Query executed !");
					else System.out.println("Failed to execute Query...");
					System.out.println("\n\n");
					break;
				}
				case 2:{
					String query = "DELETE FROM trail_name WHERE id=?";
					PreparedStatement queryStatement = con.prepareStatement(query);
					System.out.print("enter id no: ");
					int id = sc.nextInt();
					queryStatement.setInt(1, id);
					System.out.println(" ---->#");
					int r = queryStatement.executeUpdate();
					if(r>0)System.out.println("Query executed !");
					else System.out.println("Failed to execute Query...");
					System.out.println("\n\n");
					break;
				}
				case 3: {
					String query = "UPDATE trail_name SET person_name=? WHERE id=?";
					PreparedStatement queryStatement = con.prepareStatement(query);
					System.out.print("enter id to change: ");
					int id = sc.nextInt();
					queryStatement.setInt(2, id);
					System.out.println(" ---->#");
					System.out.print("enter new name: ");
					String name = sc.next();
					queryStatement.setString(1, name);
					System.out.println(" ---->#");
					int r = queryStatement.executeUpdate();
					if(r>0)System.out.println("Query executed !");
					else System.out.println("Failed to execute Query...");
					System.out.println("\n\n");
					break;
				}
				case 4: {
					String query = "SELECT * FROM trail_name;";
					PreparedStatement queryStatement = con.prepareStatement(query);
					ResultSet rs = queryStatement.executeQuery();
					while(rs.next()) {
						System.out.println(rs.getInt(1)+" 		"+rs.getString(2));
					}
					System.out.println("\n\n");
					break;
				}
				default:Run=false;
				}
			}while(Run);
			con.close();
			System.out.println("Application terminated.");
		}catch(Exception e) {System.out.println(e);
		
	}
}
}


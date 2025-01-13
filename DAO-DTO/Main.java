import java.util.*;
import java.sql.*;


public class Main {

	public static void main(String []args) {
		
		try {
			Connection con = Conection_EMP.getCon();
			EmployeeApp application = new EmployeeApp(con);
			Employee a = new Employee(256,"babboye");
			int result = application.insert_employee(a);
			if(result>0)System.out.println("Query executed !");
			else System.out.println("Query failed....");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}

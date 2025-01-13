import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/*This is apparently DAO ??*/

public class EmployeeApp implements interface_app {
	
	Connection con;
	
	EmployeeApp(Connection con){
		this.con = con;
	}

	@Override
	public int insert_employee(Employee a) {
		int i = 0;
		String query = "INSERT INTO employee_table (id,name_Emp) VALUES (?,?);";
		try {
			PreparedStatement queryStmt = con.prepareStatement(query);
			queryStmt.setInt(1, a.getId());
			queryStmt.setString(2, a.getName());
			i = queryStmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return i;
	}

	@Override
	public int remove_employee(Employee a) {
		int i = 0;
		String query = "DELETE FROM employee_table WHERE id = ?;";
		try {
			PreparedStatement queryStmt = con.prepareStatement(query);
			queryStmt.setInt(1, a.getId());
			i = queryStmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return i;
	}

	@Override
	public int update_employee(int id, String name) {
		int i = 0;
		String query = "UPDATE employee_table SET name_Emp = ? WHERE id = ?";
		try {
			PreparedStatement queryStmt = con.prepareStatement(query);
			queryStmt.setInt(2, id);
			queryStmt.setString(1, name);
			i = queryStmt.executeUpdate();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return i;
	}

	@Override
	public List<Employee> gets_employees() {
		List<Employee> final_list = new ArrayList<Employee>();
		try {
			String query = "SELECT * FROM employee_table;";
			PreparedStatement queryStmt = con.prepareStatement(query);
			ResultSet rs = queryStmt.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Employee a = new Employee(id, name);
				final_list.add(a);
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		return final_list;
	}
	
	
}

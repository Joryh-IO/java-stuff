import java.util.List;
public interface interface_app {
	public int insert_employee(Employee a);
	public int remove_employee(Employee a);
	public int update_employee(int id, String name);
	public List<Employee> gets_employees();
}
import java.util.List;

public interface EmployeeDao {

	List<Employee> findEmployeeByDepartment(String department);

	void addEmployees(List<Employee> employees);

	List<Employee> getEmployees();

}

import java.util.List;

public interface EmployeeService {
	List<Employee> findEmployeeByDepartment(String department);

	void addEmployees(List<Employee> employees);

	List<Employee> getEmployees();
}

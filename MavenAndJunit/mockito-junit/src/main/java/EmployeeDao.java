import java.util.List;

public interface EmployeeDao {

	List<Employee> findEmployeeByDepartment(String department);

}

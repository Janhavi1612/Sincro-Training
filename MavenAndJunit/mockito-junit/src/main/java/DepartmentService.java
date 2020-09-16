import java.util.List;

public interface DepartmentService {
	int getTotalEmployees(String department);

	int addDepartment(String department, List<String> departmentEmployees);

	boolean editDepartment(String employeeName, String newDepartment);
}

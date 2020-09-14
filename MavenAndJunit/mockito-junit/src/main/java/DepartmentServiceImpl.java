import java.util.List;
import java.util.stream.Collectors;

public class DepartmentServiceImpl implements DepartmentService {
	private EmployeeValidatorService employeeValidatorService;
	private EmployeeService employeeService;

	public EmployeeValidatorService getEmployeeValidatorService() {
		return employeeValidatorService;
	}

	public void setEmployeeValidatorService(EmployeeValidatorService employeeValidatorService) {
		this.employeeValidatorService = employeeValidatorService;
	}

	public EmployeeService getEmployeeService() {
		return employeeService;
	}

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public int getTotalEmployees(String department) {
		List<Employee> employees = employeeService.findEmployeeByDepartment(department);
		List<Employee> filtered = employees.stream().filter(x -> employeeValidatorService.isValid(x))
				.collect(Collectors.toList());
		return filtered.size();
	}

}

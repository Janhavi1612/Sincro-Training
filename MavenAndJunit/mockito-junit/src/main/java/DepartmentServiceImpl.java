import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
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

	public int addDepartment(String department, List<String> departmentEmployees) {
		List<Employee> newEmployees = new ArrayList<Employee>();
		Predicate<String> StringPredicate = str -> isValid(str);
		departmentEmployees.stream().filter(StringPredicate)
				.forEach(str -> newEmployees.add(new Employee(department, str)));
		if (newEmployees.size() != 0) {
			newEmployees.addAll(employeeService.getEmployees());
		}
		return newEmployees.size();
	}

	private boolean isValid(String str) {
		return !str.isEmpty() && !str.equals("bot");
	}

	@Override
	public boolean editDepartment(String employeeName, String newDepartment) {
		// Assumption: employee name is unique
		Employee employee = employeeService.getEmployee(employeeName);
		if (isValid(newDepartment)) {
			employee.setDepartment(newDepartment);
			return true;
		} else {
			return false;
		}
	}

}

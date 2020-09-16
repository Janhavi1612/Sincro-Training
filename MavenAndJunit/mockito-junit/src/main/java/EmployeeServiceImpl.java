import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employeeDao;

	public EmployeeDao getEmployeeDao() {
		return employeeDao;
	}

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	public List<Employee> findEmployeeByDepartment(String department) {
		return employeeDao.findEmployeeByDepartment(department);
	}

	@Override
	public void addEmployees(List<Employee> employees) {
		employeeDao.addEmployees(employees);

	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

}

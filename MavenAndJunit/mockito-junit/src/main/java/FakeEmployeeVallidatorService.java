
public class FakeEmployeeVallidatorService implements EmployeeValidatorService {

	public boolean isValid(Employee employee) {
		if (employee == null) {
			return false;
		}
		if (employee.getName().equals("bot")) {
			return false;
		} else {
			return true;
		}

	}

}

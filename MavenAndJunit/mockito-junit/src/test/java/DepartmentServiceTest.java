import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DepartmentServiceTest {

	@Test
	void testGetTotalEmployees() {
		List<Employee> employees = Arrays.asList(new Employee("Sam", "IT"), new Employee("bot", "IT"),
				new Employee("Kim", "IT"), new Employee("Neil", "IT"));

		DepartmentServiceImpl departmentServiceImpl = new DepartmentServiceImpl();

		EmployeeService mockEmpSrvc = mock(EmployeeService.class);
		when(mockEmpSrvc.findEmployeeByDepartment("IT")).thenReturn(employees);

		departmentServiceImpl.setEmployeeService(mockEmpSrvc);
		departmentServiceImpl.setEmployeeValidatorService(new FakeEmployeeVallidatorService());

		Assertions.assertEquals(3, departmentServiceImpl.getTotalEmployees("IT"));
		verify(mockEmpSrvc).findEmployeeByDepartment("IT");
		// verify(mockEmpSrvc).findEmployeeByDepartment("Sales");
	}

}

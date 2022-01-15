package assessment.services;

import java.util.List;

import assessment.entities.Employee;

public interface EmployeeServices {
	
	public Employee createEmployee(Employee emp);
	
	public List<Employee> getAllEmployees();

	public Employee updateEmployeeSalary(Double salary, Integer id);
	
}

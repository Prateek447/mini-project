package assessment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import assessment.entities.Employee;
import assessment.services.EmployeeServices;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServices service;
	
	@GetMapping("/fetch-employees")
	public List<Employee> getAllEmployees(){
		return service.getAllEmployees();
	}
	
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee emp) {
		return service.createEmployee(emp);
		}
      
	   @PutMapping("/update/{id}/{salary}")
	  public Employee updateEmployeeSalary(@PathVariable("id") Integer id, @PathVariable("salary") Double salary) {
		return service.updateEmployeeSalary(salary, id);
	}
}

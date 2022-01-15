package assessment.services.servicesImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assessment.entities.Employee;
import assessment.exceptions.UserAlreadyExistException;
import assessment.exceptions.UserNotFoundException;
import assessment.repositories.EmployeeRepository;
import assessment.services.EmployeeServices;

@Service
public class EmployeeServicesImpl implements EmployeeServices{
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee updateEmployeeSalary(Double salary, Integer id) {
		Employee emp = null;
		try {
			emp = repository.findById(id).get();
            emp.setSalary(salary);
            repository.save(emp);
		} catch (Exception e) {
	        throw new UserNotFoundException("User Not Found !");
		}
     
		return emp;
	}

	@Override
	public Employee createEmployee(Employee emp) {
		Employee employee = null;
		try {
			 employee= repository.findById(emp.getId()).get();   
		} catch (Exception e) {
		}
		
	    if(employee!=null)
	    	throw new UserAlreadyExistException("Employee Already Exist in the database");
	    else
		return repository.save(emp);
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = repository.findAll();
		list.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				if(o1.getSalary()<o2.getSalary()) {
					return 1;
				}
				else if(o1.getSalary()>o2.getSalary())
					return -1;
				else
				return o1.getName().compareTo(o2.getName());
				
			}
		});;
		return list;
	}

}

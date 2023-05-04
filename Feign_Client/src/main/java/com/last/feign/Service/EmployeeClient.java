// This interface defines the Feign client for the employee-service, which communicates with the API endpoints exposed by the service.
// It has methods to create, retrieve, update and delete employees using HTTP requests to the employee-service.
//This line declares the package that this class belongs to
package com.last.feign.Service;

//These are the import statements for required classes
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.last.feign.model.Employee;

@FeignClient(name = "hello-service")
public interface EmployeeClient {

	// This method creates a new employee in the employee-service by sending an HTTP POST request with the employee object as request body.
	@RequestMapping(value = "/api/employees", method = RequestMethod.POST)
	String createNewEmployee(@RequestBody Employee employee);

	// This method retrieves all employees from the employee-service by sending an HTTP GET request to the "/api/employees" endpoint.
	@GetMapping("/api/employees")
	List<Employee> getAllEmployees();

	// This method retrieves an employee from the employee-service by sending an HTTP GET request to the "/api/employees/{empid}" endpoint with the employee ID as path variable.
	@GetMapping("/api/employees/{empid}")
	Employee getEmployeeById(@PathVariable("empid") long empid);

	// This method updates an existing employee in the employee-service by sending an HTTP PUT request to the "/api/employees/{empid}" endpoint with the employee ID as path variable and employee object as request body.
	@RequestMapping(value = "/api/employees/{empid}", method = RequestMethod.PUT)
	String updateEmployeeById(@PathVariable("empid") long empid, @RequestBody Employee employee);

	// This method deletes an employee from the employee-service by sending an HTTP DELETE request to the "/api/employees/{empid}" endpoint with the employee ID as path variable.
	@DeleteMapping("/api/employees/{empid}")
	String deleteEmployeeByEmpId(@PathVariable("empid") Long empid);

	// This method deletes all employees from the employee-service by sending an HTTP DELETE request to the "/api/employees" endpoint.
	@DeleteMapping("/api/employees")
	String deleteAllEmployee();


}




// This line declares the package that this class belongs to
package com.last.feign.Controller;

// These are the import statements for required classes
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.last.feign.Service.EmployeeClient;
import com.last.feign.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// This annotation marks the class as a REST controller
@RestController
// This annotation specifies the base URL for all mappings in this class
@RequestMapping("/api")
public class EmployeeController {
   
    // This annotation tells Spring to automatically wire an instance of EmployeeClient to this field
    @Autowired
    EmployeeClient employeeClient;
    
    // This method maps to the HTTP POST method and creates a new employee using the EmployeeClient
    @PostMapping("/employees")
    public String createNewEmployee(@RequestBody Employee employee) {
        return employeeClient.createNewEmployee(employee);
    }
    
    // This method maps to the HTTP GET method and returns a list of all employees using the EmployeeClient
    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeClient.getAllEmployees();
    }
    
    // This method maps to the HTTP GET method and returns an employee by ID using the EmployeeClient
    @GetMapping("/employees/{empid}")
    public Employee getEmployeeById(@PathVariable long empid) {
        return employeeClient.getEmployeeById(empid);
    }
    
    // This method maps to the HTTP PUT method and updates an employee by ID using the EmployeeClient
    @PutMapping("/employees/{empid}")
    public String updateEmployeeById(@PathVariable long empid, @RequestBody Employee employee) {
        return employeeClient.updateEmployeeById(empid, employee);
    }
    
    // This method maps to the HTTP DELETE method and deletes an employee by ID using the EmployeeClient
    @DeleteMapping("/employees/{empid}")
    public String deleteEmployeeByEmpId(@PathVariable Long empid) {
        return employeeClient.deleteEmployeeByEmpId(empid);
    }
    
    // This method maps to the HTTP DELETE method and deletes all employees using the EmployeeClient
    @DeleteMapping("/employees")
    public String deleteAllEmployee() {
        return employeeClient.deleteAllEmployee();
    }
    
}

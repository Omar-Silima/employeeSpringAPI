package com.sms.controller;

import com.sms.entity.Employee;
import com.sms.exceptions.ResourceNotFoundException;
import com.sms.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee/api/v1/")
public class EmployeeController {

    @Autowired
    private EmployeeRepo employeeRepo;

//    get all employees

    @GetMapping("/employees")
    List<Employee> getAllEmployees(){
        return employeeRepo.findAll();
    }

//    add employee
    @PostMapping("/add-employee")
    public Employee addNewEmployee(@RequestBody Employee employee){
        return employeeRepo.save(employee);
    }

//    get employee by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " +id+ " not found"));
        return ResponseEntity.ok(employee);
    }

//    update employee
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Employee eEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " +id+ " not found"));

        eEmployee.setFirstName(employee.getFirstName());
        eEmployee.setLastName(employee.getLastName());
        eEmployee.setEmail(employee.getEmail());

        Employee uEmployee = employeeRepo.save(eEmployee);
        return ResponseEntity.ok(uEmployee);
    }

//    delete employee
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
        Employee eEmployee = employeeRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee with id " +id+ " not found"));
        employeeRepo.delete(eEmployee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

package com.employee.MyProject.controller;

import com.employee.MyProject.DTO.EmployeeDto;
import com.employee.MyProject.entity.Employee;
import com.employee.MyProject.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //create employee rest api
    @PostMapping()
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        Employee savedEmployee = employeeService.createEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
    
    //getting employee by id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeebyId(@PathVariable("id") Long employeeId) {
        EmployeeDto employee = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }    
    
    //getting all employees
    @GetMapping()
    public ResponseEntity<List<EmployeeDto>>  getAllEmployeesDto(){
        List<EmployeeDto> employees = employeeService.getAllEmployeeDto();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
    
    //Update existing employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
                                                   @RequestBody Employee employee){
        employee.setId(employeeId);
        Employee updatedEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    //Delete existing employee
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteUser(employeeId);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }
    
}
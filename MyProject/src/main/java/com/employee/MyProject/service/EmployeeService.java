package com.employee.MyProject.service;

import com.employee.MyProject.DTO.EmployeeDto;
import com.employee.MyProject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployeeDto();

    Employee updateEmployee(Employee employee);

    void deleteUser(Long employeeId);
}

package com.employee.MyProject.service.impl;

import com.employee.MyProject.DTO.EmployeeDto;
import com.employee.MyProject.entity.Employee;
import com.employee.MyProject.repository.EmployeeRepo;
import com.employee.MyProject.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService {
    private EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepo.findById(employeeId).get();
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getPosition()
        );

    }

    @Override
    public List<EmployeeDto> getAllEmployeeDto() {
        List<Employee> entity = employeeRepo.findAll();
        return entity.stream().map(employee -> new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getPosition()
        )).toList();
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Employee existingEmployee = employeeRepo.findById(employee.getId()).get();
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());
        existingEmployee.setPosition(employee.getPosition());
        existingEmployee.setSalary(employee.getSalary());
        existingEmployee.setDate(employee.getDate());

        Employee updatedEmployee = employeeRepo.save(existingEmployee);
        return updatedEmployee;
    }

    @Override
    public void deleteUser(Long employeeId) {
    employeeRepo.deleteById(employeeId);
    }
}

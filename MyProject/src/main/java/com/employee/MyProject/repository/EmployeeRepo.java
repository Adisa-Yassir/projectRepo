package com.employee.MyProject.repository;

import com.employee.MyProject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo  extends JpaRepository<Employee, Long> {
}

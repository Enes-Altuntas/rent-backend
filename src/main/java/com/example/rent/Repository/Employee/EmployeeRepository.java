package com.example.rent.Repository.Employee;

import com.example.rent.Entity.Employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}

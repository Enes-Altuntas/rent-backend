package com.example.rent.Service.Employee;

import com.example.rent.DTO.Employee.GetEmployeeDTO;
import com.example.rent.Entity.Employee.Employee;
import com.example.rent.Mapper.Employee.GetEmployeeDTOFromEntityMapper;
import com.example.rent.Repository.Employee.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final GetEmployeeDTOFromEntityMapper getEmployeeDTOFromEntityMapper;

    @Override
    public List<GetEmployeeDTO> getAllEmployees() {
        List<Employee> employeeList = employeeRepository.findAll();

        return getEmployeeDTOFromEntityMapper.fromEntityListToDTOList(employeeList);
    }
}

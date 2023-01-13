package com.example.rent.Mapper.Employee;

import com.example.rent.DTO.Employee.GetEmployeeDTO;
import com.example.rent.Entity.Employee.Employee;
import com.example.rent.Mapper.BaseEntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GetEmployeeDTOFromEntityMapper extends BaseEntityMapper<Employee, GetEmployeeDTO> {
    @Mapping(source = "id", target = "employeeId")
    @Override
    GetEmployeeDTO fromEntityToDTO(Employee employee);
}

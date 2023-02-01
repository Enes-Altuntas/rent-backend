package com.example.rent.Mapper.Employee;

import com.example.rent.DTO.Employee.GetEmployeeDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Employee.GetEmployeeResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetEmployeeResponseFromDTOMapper extends BaseResponseMapper<GetEmployeeResponse, GetEmployeeDTO> {
}

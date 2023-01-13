package com.example.rent.Controller.Employee;

import com.example.rent.DTO.Employee.GetEmployeeDTO;
import com.example.rent.Mapper.Employee.GetEmployeeResponseFromDTOMapper;
import com.example.rent.Response.Employee.GetEmployeeResponse;
import com.example.rent.Service.Employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = {"*"})
@RequestMapping("/api/v1/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final GetEmployeeResponseFromDTOMapper getEmployeeResponseFromDTOMapper;

    @GetMapping
    public ResponseEntity<List<GetEmployeeResponse>> getAllEmployees() {
        List<GetEmployeeDTO> getEmployeeDTOList = employeeService.getAllEmployees();

        List<GetEmployeeResponse> getEmployeeResponseList =
                getEmployeeResponseFromDTOMapper.fromDTOListToResponseList(getEmployeeDTOList);

        return new ResponseEntity<>(getEmployeeResponseList, HttpStatus.OK);
    }
}

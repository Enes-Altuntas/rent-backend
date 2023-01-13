package com.example.rent.Response.Employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetEmployeeResponse {

    private Integer employeeId;

    private String nameSurname;

}

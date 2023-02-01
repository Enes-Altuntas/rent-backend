package com.example.rent.Response.Recap;

import com.example.rent.Response.Employee.GetEmployeeResponse;
import com.example.rent.Response.FlatStatus.GetFlatStatusResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRecapResponse {

    private Integer flatId;

    private Integer renterId;

    private Integer flatNumber;

    private String apartmentName;

    private String city;

    private String state;

    private String paymentStatus;

    private GetEmployeeResponse employee;

    private GetFlatStatusResponse flatStatus;

}

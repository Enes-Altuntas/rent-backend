package com.example.rent.DTO.Recap;

import com.example.rent.DTO.Employee.GetEmployeeDTO;
import com.example.rent.DTO.FlatStatus.GetFlatStatusDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRecapDTO {

    private Integer flatId;

    private Integer renterId;

    private Integer flatNumber;

    private String apartmentName;

    private String city;

    private String state;

    private String paymentStatus;

    private GetEmployeeDTO employee;

    private GetFlatStatusDTO flatStatus;

}

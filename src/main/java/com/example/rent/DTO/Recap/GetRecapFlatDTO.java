package com.example.rent.DTO.Recap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRecapFlatDTO {

    private Integer flatId;

    private String apartmentName;

    private Integer flatNumber;

    private Integer flatPrice;

    private String flatType;

    private String currency;

    private String flatArea;

    private Date endDate;

    private String status;

}

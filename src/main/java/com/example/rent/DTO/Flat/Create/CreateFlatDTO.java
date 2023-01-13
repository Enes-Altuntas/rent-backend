package com.example.rent.DTO.Flat.Create;

import lombok.Data;

import java.util.List;

@Data
public class CreateFlatDTO {

    private Integer flatNumber;

    private Integer apartmentId;

    private Integer flatTypeId;

    private Integer flatPrice;

    private String flatArea;

    private Integer currencyId;

    private Integer flatStatusId;

    private Integer flatUsageId;

    private Integer employeeId;

    private List<Integer> ownerId;

}

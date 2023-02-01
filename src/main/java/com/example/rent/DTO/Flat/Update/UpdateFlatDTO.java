package com.example.rent.DTO.Flat.Update;

import lombok.Data;

import java.util.List;

@Data
public class UpdateFlatDTO {

    private Integer flatId;

    private Integer flatNumber;

    private Integer flatTypeId;

    private Integer flatPrice;

    private String flatArea;

    private Integer currencyId;

    private Integer flatStatusId;

    private Integer flatUsageId;

    private Integer employeeId;

    private List<Integer> ownerId;

}

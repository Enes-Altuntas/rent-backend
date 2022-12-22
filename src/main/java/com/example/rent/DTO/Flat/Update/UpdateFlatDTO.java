package com.example.rent.DTO.Flat.Update;

import lombok.Data;

@Data
public class UpdateFlatDTO {

    private Integer flatId;

    private Integer flatNumber;

    private Integer flatTypeId;

    private Integer flatPrice;

    private String flatArea;

    private Integer currencyId;

}

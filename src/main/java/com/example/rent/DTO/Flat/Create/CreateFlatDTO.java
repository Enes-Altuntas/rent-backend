package com.example.rent.DTO.Flat.Create;

import lombok.Data;

@Data
public class CreateFlatDTO {

    private Integer flatNumber;

    private Integer apartmentId;

    private Integer flatTypeId;

    private Integer flatPrice;

    private String flatArea;

    private Integer currencyId;

}

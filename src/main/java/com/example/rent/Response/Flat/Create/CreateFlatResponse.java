package com.example.rent.Response.Flat.Create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateFlatResponse {

    private Integer flatNumber;

    private Integer apartmentId;

    private Integer renterId;

    private Integer flatTypeId;

    private Integer flatPrice;

    private String flatArea;

    private Integer currencyId;

}

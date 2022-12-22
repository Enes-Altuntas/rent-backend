package com.example.rent.Response.Flat.Get;

import com.example.rent.Response.Apartment.GetApartmentRenterResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatRecapResponse {

    private Integer flatId;

    private Integer flatNumber;

    private String flatType;

    private Integer flatPrice;

    private String currency;

    private String flatArea;

    private GetApartmentRenterResponse renter;

}

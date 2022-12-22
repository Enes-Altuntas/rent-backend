package com.example.rent.Response.Flat.Get;

import com.example.rent.Response.Apartment.GetApartmentRenterResponse;
import com.example.rent.Response.Currency.GetCurrencyResponse;
import com.example.rent.Response.FlatType.GetFlatTypeResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatResponse {

    private Integer apartmentId;

    private Integer flatId;

    private Integer flatNumber;

    private GetFlatTypeResponse flatType;

    private Integer flatPrice;

    private GetCurrencyResponse currency;

    private String flatArea;

    private GetApartmentRenterResponse renter;

}

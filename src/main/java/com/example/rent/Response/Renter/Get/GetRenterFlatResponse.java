package com.example.rent.Response.Renter.Get;

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
public class GetRenterFlatResponse {

    private Integer flatId;

    private Integer flatNumber;

    private GetFlatTypeResponse flatType;

    private Integer flatPrice;

    private String flatArea;

    private GetCurrencyResponse currency;

    private String address;

}

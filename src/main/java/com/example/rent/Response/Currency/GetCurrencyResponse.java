package com.example.rent.Response.Currency;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetCurrencyResponse {

    private Integer currencyId;

    private String currencyValue;

}

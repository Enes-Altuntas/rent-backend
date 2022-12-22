package com.example.rent.DTO.Renter.Get;

import com.example.rent.DTO.Currency.GetCurrencyDTO;
import com.example.rent.DTO.FlatType.GetFlatTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRenterFlatDTO {

    private Integer flatId;

    private Integer flatNumber;

    private GetFlatTypeDTO flatType;

    private Integer flatPrice;

    private String flatArea;

    private GetCurrencyDTO currency;

    private String address;

}

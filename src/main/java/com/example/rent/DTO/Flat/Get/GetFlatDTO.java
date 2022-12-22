package com.example.rent.DTO.Flat.Get;

import com.example.rent.DTO.Apartment.Get.GetApartmentRenterDTO;
import com.example.rent.DTO.Currency.GetCurrencyDTO;
import com.example.rent.DTO.FlatType.GetFlatTypeDTO;
import lombok.Data;

@Data
public class GetFlatDTO {

    private Integer apartmentId;

    private Integer flatId;

    private Integer flatNumber;

    private GetFlatTypeDTO flatType;

    private Integer flatPrice;

    private GetCurrencyDTO currency;

    private String flatArea;

    private GetApartmentRenterDTO renter;

}

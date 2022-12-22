package com.example.rent.Response.Contract.Create;

import com.example.rent.Response.Apartment.GetApartmentRenterResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateContractResponse {

    private Integer apartmentId;

    private Integer flatId;

    private GetApartmentRenterResponse renter;

}

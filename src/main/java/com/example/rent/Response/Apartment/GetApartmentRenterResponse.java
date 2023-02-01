package com.example.rent.Response.Apartment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetApartmentRenterResponse {

    private Integer renterId;

    private String nameSurname;

}

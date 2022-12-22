package com.example.rent.DTO.Apartment.Create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateApartmentDTO {

    private String apartmentName;

    private Integer number;

    private String streetName;

    private String neighborhood;

    private String city;

    private String state;

}

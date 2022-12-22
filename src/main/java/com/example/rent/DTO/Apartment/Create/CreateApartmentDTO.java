package com.example.rent.DTO.Apartment.Create;

import com.example.rent.DTO.Flat.Get.GetFlatDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateApartmentDTO {

    private Integer apartmentId;

    private String apartmentName;

    private Integer number;

    private String streetName;

    private String neighborhood;

    private String city;

    private String state;

    private List<GetFlatDTO> flatList;

}

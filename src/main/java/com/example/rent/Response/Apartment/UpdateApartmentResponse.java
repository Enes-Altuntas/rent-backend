package com.example.rent.Response.Apartment;

import com.example.rent.Response.Flat.Get.GetFlatResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UpdateApartmentResponse {

    private Integer apartmentId;

    private String apartmentName;

    private Integer number;

    private String streetName;

    private String neighborhood;

    private String city;

    private String state;

    private List<GetFlatResponse> flatList;

}

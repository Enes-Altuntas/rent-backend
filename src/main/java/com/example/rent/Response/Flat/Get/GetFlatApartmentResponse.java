package com.example.rent.Response.Flat.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatApartmentResponse {

    private Integer apartmentId;

    private List<GetFlatResponse> flatList;

}

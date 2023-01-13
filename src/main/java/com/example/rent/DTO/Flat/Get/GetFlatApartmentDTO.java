package com.example.rent.DTO.Flat.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatApartmentDTO {

    private Integer apartmentId;

    private List<GetFlatDTO> flatList;
}

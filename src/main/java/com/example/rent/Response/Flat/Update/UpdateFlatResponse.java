package com.example.rent.Response.Flat.Update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UpdateFlatResponse {

    private Integer id;

    private Integer flatNumber;

    private Integer apartmentId;

    private Integer renterId;

}

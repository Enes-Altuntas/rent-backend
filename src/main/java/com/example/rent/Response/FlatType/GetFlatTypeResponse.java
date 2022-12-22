package com.example.rent.Response.FlatType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatTypeResponse {

    private Integer flatTypeId;

    private String flatTypeValue;

}

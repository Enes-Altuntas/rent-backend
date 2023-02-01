package com.example.rent.Response.FlatStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatStatusResponse {

    private Integer flatStatusId;

    private String statusValue;

}

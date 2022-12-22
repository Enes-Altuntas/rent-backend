package com.example.rent.Response.Land.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetLandResponse {

    private String province;

    private String state;

    private String neighbourhood;

    private Integer adaNo;

    private Integer parselNo;

    private Integer price;

    private List<GetLandOwnerResponse> owners;

}

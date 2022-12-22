package com.example.rent.DTO.Land.Get;

import lombok.Data;

import java.util.List;

@Data
public class GetLandDTO {
    private String province;

    private String state;

    private String neighbourhood;

    private Integer adaNo;

    private Integer parselNo;

    private Integer price;

    private List<GetLandOwnerDTO> owners;
}

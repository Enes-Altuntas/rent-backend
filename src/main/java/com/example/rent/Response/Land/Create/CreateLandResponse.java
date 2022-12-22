package com.example.rent.Response.Land.Create;

import com.example.rent.Entity.Renter.Renter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateLandResponse {

    private Integer id;

    private String province;

    private String state;

    private String neighbourhood;

    private Integer adaNo;

    private Integer parselNo;

    private Integer price;

}

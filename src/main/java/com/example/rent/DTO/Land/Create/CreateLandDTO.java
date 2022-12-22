package com.example.rent.DTO.Land.Create;

import com.example.rent.DTO.Owner.Create.CreateOwnerDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateLandDTO {

    private Integer id;

    private String province;

    private String state;

    private String neighbourhood;

    private Integer adaNo;

    private Integer parselNo;

    private Integer price;

    private List<CreateOwnerDTO> owner;
}

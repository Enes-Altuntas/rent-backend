package com.example.rent.DTO.FlatType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatTypeDTO {

    private Integer flatTypeId;

    private String flatTypeValue;

}

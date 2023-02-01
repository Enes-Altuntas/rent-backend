package com.example.rent.DTO.FlatStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatStatusDTO {

    private Integer flatStatusId;

    private String statusValue;
}

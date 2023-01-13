package com.example.rent.DTO.FlatUsage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatUsageDTO {

    private Integer flatUsageId;

    private String usageValue;
}

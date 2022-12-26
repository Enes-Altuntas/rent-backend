package com.example.rent.Response.FlatUsage;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FlatUsageResponse {
    private Integer flatUsageId;

    private String usageValue;
}


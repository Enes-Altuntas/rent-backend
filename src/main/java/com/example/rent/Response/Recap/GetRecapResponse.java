package com.example.rent.Response.Recap;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRecapResponse {

    private Integer renterId;

    private Integer renterCode;

    private String renterName;

    private String address;

    private String paymentStatus;

}

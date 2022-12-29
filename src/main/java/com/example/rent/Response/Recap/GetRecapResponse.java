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

    private Integer flatId;

    private Integer renterId;

    private String address;

    private Integer flatNumber;

    private String paymentStatus;

}

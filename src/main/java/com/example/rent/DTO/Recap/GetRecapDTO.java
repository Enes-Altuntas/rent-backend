package com.example.rent.DTO.Recap;

import lombok.Data;

@Data
public class GetRecapDTO {

    private Integer renterId;

    private Integer renterCode;

    private String renterName;

    private String address;

    private String paymentStatus;

}

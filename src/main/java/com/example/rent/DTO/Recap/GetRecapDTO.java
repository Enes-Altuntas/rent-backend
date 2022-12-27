package com.example.rent.DTO.Recap;

import com.example.rent.DTO.Payment.GetPaymentDTO;
import lombok.Data;

import java.util.List;

@Data
public class GetRecapDTO {

    private Integer renterId;

    private String renterCode;

    private String renterName;

    private List<GetPaymentDTO> payments;

    private String address;

}

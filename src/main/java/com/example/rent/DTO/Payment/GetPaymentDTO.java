package com.example.rent.DTO.Payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetPaymentDTO {

    private Integer paymentId;

    private GetPaymentFileDTO file;

    private Integer flatNumber;

    private String address;

}

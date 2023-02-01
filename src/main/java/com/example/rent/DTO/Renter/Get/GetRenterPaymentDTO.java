package com.example.rent.DTO.Renter.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRenterPaymentDTO {

    private Integer paymentId;

    private Integer flatId;

    private GetRenterFileDTO file;

    private Date paymentDate;

    private String address;

}

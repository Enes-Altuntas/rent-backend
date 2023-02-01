package com.example.rent.Response.Renter.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRenterPaymentResponse {

    private Integer paymentId;

    private Integer flatId;

    private Date paymentDate;

    private GetRenterFileResponse file;

    private String address;

}

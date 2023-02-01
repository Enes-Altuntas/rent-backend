package com.example.rent.Response.Payment;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPaymentResponse {

  private Integer paymentId;

  private GetPaymentFileResponse file;

  private Integer flatNumber;

  private String address;

  private Date paymentDate;

}

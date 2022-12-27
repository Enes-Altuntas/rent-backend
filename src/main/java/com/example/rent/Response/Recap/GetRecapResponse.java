package com.example.rent.Response.Recap;

import com.example.rent.Response.Flat.Get.GetFlatRecapResponse;
import com.example.rent.Response.Payment.GetPaymentResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRecapResponse {

    private Integer renterId;

    private String renterCode;

    private String renterName;

    private List<GetPaymentResponse> payments;

    private String address;

}

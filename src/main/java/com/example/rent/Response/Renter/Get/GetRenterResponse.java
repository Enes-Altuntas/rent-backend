package com.example.rent.Response.Renter.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRenterResponse {

    private Integer renterId;

    private String code;

    private String tckn;

    private String iban;

    private String nameSurname;

    private String email;

    private String phoneNumber;

    private boolean active;

    private List<GetRenterFlatResponse> flatList;

    private List<GetRenterPaymentResponse> payments;

}

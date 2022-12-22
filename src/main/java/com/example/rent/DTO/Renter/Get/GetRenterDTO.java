package com.example.rent.DTO.Renter.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetRenterDTO {

    private Integer renterId;

    private String code;

    private String tckn;

    private String nameSurname;

    private String email;

    private String phoneNumber;

    private boolean isActive;

    private List<GetRenterFlatDTO> flatList;

    private List<GetRenterPaymentDTO> payments;

}

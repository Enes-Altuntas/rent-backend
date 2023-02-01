package com.example.rent.DTO.Renter.Update;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UpdateRenterDTO {

    private Integer renterId;

    private String tckn;

    private String code;

    private String nameSurname;

    private String email;

    private String phoneNumber;

}

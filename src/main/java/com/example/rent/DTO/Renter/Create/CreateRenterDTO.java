package com.example.rent.DTO.Renter.Create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateRenterDTO {

    private String tckn;

    private String nameSurname;

    private String email;

    private String phoneNumber;

}

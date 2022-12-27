package com.example.rent.Request.Renter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateRenterRequest {

    @NotBlank(message = "T.C. kimlik no alanı boş bırakılamaz!")
    private String tckn;

    @NotBlank(message = "İsim alanı boş bırakılamaz!")
    private String nameSurname;

    @Email
    @NotBlank(message = "Email boş bırakılamaz!")
    private String email;

    @NotBlank(message = "Telefon numarası alanı boş bırakılamaz!")
    private String phoneNumber;

    @NotBlank(message = "IBAN alanı boş bırakılamaz!")
    private String iban;

}

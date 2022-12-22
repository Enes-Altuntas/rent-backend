package com.example.rent.Request.Owner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateOwnerRequest {

    @NotBlank(message = "T.C. kimlik no alanı boş bırakılamaz!")
    private String tckn;

    @NotBlank(message = "İsim alanı boş bırakılamaz!")
    private String nameSurname;

    @NotNull(message = "Telefon numarası alanı boş bırakılamaz!")
    private String phoneNumber;

}

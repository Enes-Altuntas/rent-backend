package com.example.rent.Request.Renter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UpdateRenterRequest {

  @NotNull(message = "Renter id'si boş bırakılamaz!")
  private Integer renterId;

  @NotBlank(message = "T.C. kimlik no alanı boş bırakılamaz!")
  private String tckn;

  @NotBlank(message = "İsim alanı boş bırakılamaz!")
  private String nameSurname;
  
  private String code;

  @Email
  @NotBlank(message = "Email boş bırakılamaz!")
  private String email;

  @NotBlank(message = "Telefon numarası alanı boş bırakılamaz!")
  private String phoneNumber;

}

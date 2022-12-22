package com.example.rent.Request.Apartment;

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
public class UpdateApartmentRequest {

    @NotNull(message = "Apartman id'si boş bırakılamaz!")
    private Integer apartmentId;

    @NotBlank(message = "Apartman adı alanı boş bırakılamaz!")
    private String apartmentName;

    @NotNull(message = "Apartman numarası alanı boş bırakılamaz!")
    private Integer number;

    @NotBlank(message = " Sokak adı alanı boş bırakılamaz!")
    private String streetName;

    @NotBlank(message = "Mahalle adı alanı boş bırakılamaz!")
    private String neighborhood;

    @NotBlank(message = "Şehir adı alanı boş bırakılamaz!")
    private String city;

    @NotBlank(message = "İlçe alanı boş bırakılamaz!")
    private String state;

}

package com.example.rent.Request.Flat.Update;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateFlatRequest {

    @NotNull(message = "Daire id'si boş bırakılamaz!")
    private Integer flatId;

    @NotNull(message = "Daire numarası boş bırakılamaz!")
    private Integer flatNumber;

    @NotNull(message = "Daire tipi boş bırakılamaz!")
    private Integer flatTypeId;

    @NotNull(message = "Daire fiyatı boş bırakılamaz!")
    private Integer flatPrice;

    @NotNull(message = "Daire metrekaresi boş bırakılamaz!")
    private Integer flatArea;

    @NotNull(message = "Daire para birimi boş bırakılamaz!")
    private Integer currencyId;

    @NotBlank(message = "Daire muhattap kişi ismi-soyismi boş bırakılamaz!")
    private String contactNameSurname;

    @NotBlank(message = "Daire muhattap kişi email boş bırakılamaz!")
    private String contactEmail;

    @NotBlank(message = "Daire muhattap kişi tckn boş bırakılamaz!")
    private String contactTckn;

    @NotBlank(message = "Daire muhattap kişi banka ismi boş bırakılamaz!")
    private String contactBankName;

    @NotBlank(message = "Daire muhattap kişi banka şube kodu boş bırakılamaz!")
    private String contactBankBranch;

    @NotNull(message = "Daire muhattap kişi banka hesap no boş bırakılamaz!")
    private Integer contactAccountNumber;

    @NotBlank(message = "Daire muhattap kişi IBAN boş bırakılamaz!")
    private String contactIban;

    @NotBlank(message = "Daire muhattap kişi telefon no boş bırakılamaz!")
    private String contactPhoneNumber;

    @NotBlank(message = "Daire muhattap kişi adresi boş bırakılamaz!")
    private String contactAddress;

}

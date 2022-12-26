package com.example.rent.DTO.Flat.Create;

import lombok.Data;

@Data
public class CreateFlatDTO {

    private Integer flatNumber;

    private Integer apartmentId;

    private Integer flatTypeId;

    private Integer flatPrice;

    private String flatArea;

    private Integer currencyId;

    private String contactNameSurname;

    private String contactEmail;

    private String contactTckn;

    private String contactBankName;

    private String contactBankBranch;

    private Integer contactAccountNumber;

    private String contactIban;

    private String contactPhoneNumber;

    private String contactAddress;

}

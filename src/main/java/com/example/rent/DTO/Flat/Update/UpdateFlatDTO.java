package com.example.rent.DTO.Flat.Update;

import lombok.Data;

@Data
public class UpdateFlatDTO {

    private Integer flatId;

    private Integer flatNumber;

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

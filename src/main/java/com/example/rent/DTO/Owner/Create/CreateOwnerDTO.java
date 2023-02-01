package com.example.rent.DTO.Owner.Create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateOwnerDTO {

    private Integer ownerId;

    private String nameSurname;

    private String tckn;

    private String phoneNumber;

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

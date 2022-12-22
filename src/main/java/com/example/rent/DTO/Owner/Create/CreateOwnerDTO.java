package com.example.rent.DTO.Owner.Create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateOwnerDTO {

    private Integer ownerId;

    private String nameSurname;

    private String tckn;

    private String phoneNumber;

}

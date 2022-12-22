package com.example.rent.DTO.Owner.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetOwnerDTO {

    private Integer ownerId;

    private String nameSurname;

    private String tckn;

    private String phoneNumber;

}

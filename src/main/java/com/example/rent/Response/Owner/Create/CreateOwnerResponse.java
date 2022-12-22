package com.example.rent.Response.Owner.Create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateOwnerResponse {

    private Integer ownerId;

    private String nameSurname;

    private String tckn;

    private String phoneNumber;

}

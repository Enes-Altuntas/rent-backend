package com.example.rent.Response.Land.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetLandOwnerResponse {

    private Integer ownerId;

    private String nameSurname;

    private String phoneNumber;

}

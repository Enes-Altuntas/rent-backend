package com.example.rent.Response.Flat.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatOwnerResponse {

    private Integer ownerId;

    private String nameSurname;

}

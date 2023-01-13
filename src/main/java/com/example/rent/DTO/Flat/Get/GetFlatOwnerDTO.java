package com.example.rent.DTO.Flat.Get;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class GetFlatOwnerDTO {
    private Integer ownerId;

    private String nameSurname;
}

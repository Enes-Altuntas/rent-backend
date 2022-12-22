package com.example.rent.DTO.Contract.Delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteContractDTO {

    private Integer apartmentId;

    private Integer flatId;

}

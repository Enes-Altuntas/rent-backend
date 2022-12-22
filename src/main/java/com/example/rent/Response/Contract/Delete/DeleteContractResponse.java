package com.example.rent.Response.Contract.Delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteContractResponse {

    private Integer apartmentId;

    private Integer flatId;

}

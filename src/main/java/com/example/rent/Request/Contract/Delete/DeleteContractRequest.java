package com.example.rent.Request.Contract.Delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteContractRequest {

    @NotNull(message = "Daire id'si boş bırakılamaz!")
    private Integer flatId;

}

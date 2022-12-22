package com.example.rent.Request.Contract.Create;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateContractRequest {

    @NotNull(message = "Daire id'si boş bırakılamaz!")
    private Integer flatId;

    @NotNull(message = "Kiracı id'si boş bırakılamaz!")
    private Integer renterId;

    @NotNull(message = "Başlangıç tarihi boş bırakılamaz!")
    private Date startDate;

    @NotNull(message = "Bitiş tarihi boş bırakılamaz!")
    private Date endDate;

    @NotNull(message = "Ödeme gecikme gün sayısı boş bırakılamaz!")
    private Integer paymentDue;

}

package com.example.rent.Request.Flat.Update;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class UpdateFlatRequest {

    @NotNull(message = "Daire id'si boş bırakılamaz!")
    private Integer flatId;

    @NotNull(message = "Daire numarası boş bırakılamaz!")
    private Integer flatNumber;

    @NotNull(message = "Daire tipi boş bırakılamaz!")
    private Integer flatTypeId;

    @NotNull(message = "Daire fiyatı boş bırakılamaz!")
    private Integer flatPrice;

    @NotNull(message = "Daire metrekaresi boş bırakılamaz!")
    private Integer flatArea;

    @NotNull(message = "Daire para birimi boş bırakılamaz!")
    private Integer currencyId;

    @NotNull(message = "Daire tipi boş bırakılamaz!")
    private Integer flatStatusId;

    @NotNull(message = "Daire kullanım tipi boş bırakılamaz!")
    private Integer flatUsageId;

    @NotNull(message = "İlgili personel boş bırakılamaz!")
    private Integer employeeId;

    @NotNull(message = "Daire sahipleri boş bırakılamaz!")
    private List<Integer> ownerId;

}

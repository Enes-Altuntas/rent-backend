package com.example.rent.Request.Flat.Create;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateFlatRequest {

    @NotNull(message = "Daire numarası boş bırakılamaz!")
    private Integer flatNumber;

    @NotNull(message = "Apartman id'si boş bırakılamaz!")
    private Integer apartmentId;

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

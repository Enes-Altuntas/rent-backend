package com.example.rent.Request.Land;

import com.example.rent.Entity.Owner.Owner;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class CreateLandRequest {

    @NotBlank(message = "İl adı alanı boş bırakılamaz!")
    private String province;

    @NotBlank(message = "İlçe adı alanı boş bırakılamaz!")
    private String state;

    @NotBlank(message = "Mahalle adı alanı boş bırakılamaz!")
    private String neighbourhood;

    @NotNull(message = "Ada numarası boş bırakılamaz!")
    private Integer adaNo;

    @NotNull(message = "Parsel numarası boş bırakılamaz!")
    private Integer parselNo;

    @NotNull(message = "Fiyat alanı boş bırakılamaz!")
    private Integer price;

    private List<Owner> owner;

}

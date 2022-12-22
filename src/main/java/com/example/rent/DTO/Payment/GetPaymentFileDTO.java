package com.example.rent.DTO.Payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPaymentFileDTO {

    private Integer fileId;

    private String name;

    private String url;

    private String type;

    private long size;

}

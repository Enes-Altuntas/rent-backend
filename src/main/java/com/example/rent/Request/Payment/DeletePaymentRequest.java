package com.example.rent.Request.Payment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeletePaymentRequest {

    @NotNull(message = "Ödeme id'si boş bırakılamaz!")
    private Integer paymentId;
    
}

package com.example.rent.Service.Payment;

import com.example.rent.DTO.Payment.CreatePaymentDTO;
import com.example.rent.DTO.Payment.DeletePaymentDTO;
import com.example.rent.DTO.Payment.GetPaymentDTO;
import org.springframework.web.multipart.MultipartFile;

public interface PaymentService {
    GetPaymentDTO createPayment(CreatePaymentDTO createPaymentDTO, MultipartFile multipartFile);

    void deletePayment(DeletePaymentDTO deletePaymentDTO);
}

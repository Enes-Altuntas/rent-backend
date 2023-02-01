package com.example.rent.Service.Payment;

import com.example.rent.DTO.Payment.CreatePaymentDTO;
import com.example.rent.DTO.Payment.DeletePaymentDTO;
import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import org.springframework.web.multipart.MultipartFile;

public interface PaymentService {

  GetRenterDTO createPayment(CreatePaymentDTO createPaymentDTO, MultipartFile multipartFile);

  GetRenterDTO deletePayment(DeletePaymentDTO deletePaymentDTO);
}

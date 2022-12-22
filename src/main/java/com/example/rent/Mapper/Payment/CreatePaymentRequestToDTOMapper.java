package com.example.rent.Mapper.Payment;

import com.example.rent.DTO.Payment.CreatePaymentDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Payment.CreatePaymentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreatePaymentRequestToDTOMapper extends BaseRequestMapper<CreatePaymentRequest, CreatePaymentDTO> {
}

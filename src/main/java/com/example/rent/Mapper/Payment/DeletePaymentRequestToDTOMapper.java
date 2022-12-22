package com.example.rent.Mapper.Payment;

import com.example.rent.DTO.Payment.DeletePaymentDTO;
import com.example.rent.Mapper.BaseRequestMapper;
import com.example.rent.Request.Payment.DeletePaymentRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeletePaymentRequestToDTOMapper extends BaseRequestMapper<DeletePaymentRequest, DeletePaymentDTO> {
}

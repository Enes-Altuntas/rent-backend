package com.example.rent.Mapper.Payment;

import com.example.rent.DTO.Payment.GetPaymentDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Payment.GetPaymentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GetPaymentDTOToResponseMapper extends BaseResponseMapper<GetPaymentResponse, GetPaymentDTO> {
}

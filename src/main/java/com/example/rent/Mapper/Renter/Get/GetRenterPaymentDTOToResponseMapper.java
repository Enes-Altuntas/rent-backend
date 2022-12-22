package com.example.rent.Mapper.Renter.Get;

import com.example.rent.DTO.Renter.Get.GetRenterPaymentDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Renter.Get.GetRenterPaymentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GetRenterFileDTOToResponseMapper.class})
public interface GetRenterPaymentDTOToResponseMapper extends BaseResponseMapper<GetRenterPaymentResponse, GetRenterPaymentDTO> {
}

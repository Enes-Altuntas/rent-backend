package com.example.rent.Mapper.Renter.Get;

import com.example.rent.DTO.Renter.Get.GetRenterDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Renter.Get.GetRenterResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GetRenterFlatDTOToResponseMapper.class, GetRenterPaymentDTOToResponseMapper.class})
public interface GetRenterDTOToResponseMapper extends BaseResponseMapper<GetRenterResponse, GetRenterDTO> {
}

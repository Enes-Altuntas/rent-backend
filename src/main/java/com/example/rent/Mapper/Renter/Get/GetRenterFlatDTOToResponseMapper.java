package com.example.rent.Mapper.Renter.Get;

import com.example.rent.DTO.Renter.Get.GetRenterFlatDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Mapper.Currency.GetCurrencyDTOToResponseMapper;
import com.example.rent.Mapper.FlatType.GetFlatTypeDTOToResponseMapper;
import com.example.rent.Response.Renter.Get.GetRenterFlatResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GetFlatTypeDTOToResponseMapper.class, GetCurrencyDTOToResponseMapper.class})
public interface GetRenterFlatDTOToResponseMapper extends BaseResponseMapper<GetRenterFlatResponse, GetRenterFlatDTO> {
}

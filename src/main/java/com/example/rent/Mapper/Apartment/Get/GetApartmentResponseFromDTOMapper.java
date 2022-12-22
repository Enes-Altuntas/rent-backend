package com.example.rent.Mapper.Apartment.Get;

import com.example.rent.DTO.Apartment.Get.GetApartmentDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Mapper.Flat.Get.GetFlatResponseFromDTOMapper;
import com.example.rent.Response.Apartment.GetApartmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GetFlatResponseFromDTOMapper.class})
public interface GetApartmentResponseFromDTOMapper extends BaseResponseMapper<GetApartmentResponse, GetApartmentDTO> {
    @Override
    GetApartmentResponse fromDTOToResponse(GetApartmentDTO getApartmentDTO);
}

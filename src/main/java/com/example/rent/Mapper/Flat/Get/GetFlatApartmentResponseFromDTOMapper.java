package com.example.rent.Mapper.Flat.Get;

import com.example.rent.DTO.Flat.Get.GetFlatApartmentDTO;
import com.example.rent.Mapper.BaseResponseMapper;
import com.example.rent.Response.Flat.Get.GetFlatApartmentResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {GetFlatResponseFromDTOMapper.class})
public interface GetFlatApartmentResponseFromDTOMapper extends BaseResponseMapper<GetFlatApartmentResponse, GetFlatApartmentDTO> {
}
